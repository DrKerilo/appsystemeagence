package fr.adaming.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

import fr.adaming.dao.IVisiteDao;
import fr.adaming.model.Adresse;
import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Visite;

@Service("vstService")
@Transactional
public class VisiteServiceImpl implements IVisiteService {

	@Autowired
	private IVisiteDao vstDao;

	@Override
	public List<Visite> getAllVisite() {
		return vstDao.getAllVisite();
	}

	@Override
	public Visite addVisite(Visite vst) {
		Visite visite = vstDao.addVisite(vst);

		genererPDF(visite);

		sendMail(visite);

		return visite;
	}

	@Override
	public Visite updateVisite(Visite vst) {
		Visite visite = vstDao.addVisite(vst);

		genererPDF(visite);

		sendMail2(visite);

		return vstDao.updateVisite(vst);
	}

	@Override
	public int deleteVisite(int id) {
		return vstDao.deleteVisite(id);
	}

	@Override
	public List<Visite> getVisiteByAgent(int idAgent) {
		return vstDao.getVisiteByAgent(idAgent);
	}

	@Override
	public List<Visite> getVisiteByClient(int idClient) {
		return vstDao.getVisiteByClient(idClient);
	}

	@Override
	public String getFile(int id) {
		StringBuilder sOut = new StringBuilder();
		String input = System.getProperty("user.home");
		for (int i = 0; i < input.length(); i++) {
			if (i > 0 && input.charAt(i) == '\\') {

				sOut.append("\\");
			}
			sOut.append(input.charAt(i));
		}

		sOut.append("\\\\Desktop\\\\Biens\\\\BienImmob" + String.format("%03d", id) + ".pdf");

		String path = sOut.toString();
		return path;
	}

	@Override
	public void genererPDF(Visite visite) {
		try {
			BienImmobilier bien = visite.getBienImmo();
			Adresse adresse = bien.getAdresse();
			
			Document document = new Document(PageSize.A4, 75, 75, 75, 75);

			String path = getFile(visite.getBienImmo().getId());

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
			
			Paragraph titre = new Paragraph("Jean-Michel SCRUM\nBien immobilier n°" + bien.getId(), FontFactory
					.getFont(FontFactory.HELVETICA_BOLD, 18, Font.UNDERLINE, new CMYKColor(54, 255, 201, 0)));
			titre.setSpacingAfter(20);
			document.add(titre);
			
			
			
			Paragraph sousTitre1 = new Paragraph(
					"Adresse : " + adresse.getNumero() + ", " + adresse.getRue() + "\n" + adresse.getCodePostal() + " " + adresse.getLocalite()
					+ "\nStatut : " + bien.getStatut() + " \n"
							+ "Date de soumission : " + bien.getDateSoumission() 
							+ "\nDate de mise à disposition : " + bien.getDateDisposition()
							+ "\n",
//							+ co.getClient().getTel() + "\n" + co.getClient().getEmail(),
					FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 15));
			sousTitre1.setSpacingAfter(20);
			document.add(sousTitre1);

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void sendMail(Visite visite) {
		// TODO Auto-generated method stub
	}

	@Override
	public void sendMail2(Visite visite) {
		// TODO Auto-generated method stub

	}

}
