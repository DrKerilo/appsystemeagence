package fr.adaming.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Client;
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
			ClasseStandard cs = bien.getClasseStandard();

			String offre = "";
			if (cs.getModeOffre() == "Acheter") {
				offre = "Achat";
			} else if (cs.getModeOffre() == "Louer") {
				offre = "Location";
			}

			Document document = new Document(PageSize.A4, 75, 75, 75, 75);

			String path = getFile(visite.getBienImmo().getId());

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));

			Paragraph titre = new Paragraph("Jean-Michel SCRUM\nBien immobilier n°" + bien.getId(), FontFactory
					.getFont(FontFactory.HELVETICA_BOLD, 18, Font.UNDERLINE, new CMYKColor(54, 255, 201, 0)));
			titre.setSpacingAfter(20);
			document.add(titre);

			Paragraph parag1 = new Paragraph("Type de bien : " + cs.getType() + "\nType d'offre " + offre
			// + "\nPrix maximum : " + cs.getPrixMax() + "€\nSuperficie minimale
			// : "
			// est ce que cela doit se retrouver côté client ?
					, FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 15));
			parag1.setSpacingAfter(20);
			document.add(parag1);

			String partie2 = "";

			if (bien.getClasseStandard().getModeOffre() == "Louer") {
				partie2 = "\nCaution locative : " + bien.getCautionLocative() + "€\nLoyer mensuel : "
						+ bien.getLoyerMensuel() + "€"
						// + "\n Montant mensuel des charges : " +
						// bien.getMontantMensuelCharges()
						+ "\nType de bail : " + bien.getTypeBail() + "\nGarniture : " + bien.getGarniture();
			} else if (bien.getClasseStandard().getModeOffre() == "Acheter") {
				partie2 = "\nPrix demandé : " + bien.getPrixAchat();

				if (cs.getType() == "Terrain") {
					String etat = "";
					if (bien.getEtat() == "A_restaurer") {
						etat = "à restaurer";
					} else {
						etat = bien.getEtat();
					}
					partie2 = partie2 + "\nEtat du terrain : " + etat;
				}
			}

			Paragraph parag2 = new Paragraph(
					"Adresse : " + adresse.getNumero() + ", " + adresse.getRue() + "\n" + adresse.getCodePostal() + " "
							+ adresse.getLocalite() + "\nStatut : " + bien.getStatut() + " \n" + "Date de soumission : "
							+ bien.getDateSoumission() + "\nDate de mise à disposition : " + bien.getDateDisposition()
							+ "\nRevenu cadastral : " + bien.getRevenuCadastral() + partie2,
					FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 15));
			parag2.setSpacingAfter(20);
			document.add(parag2);
			
			// TODO inserer image

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void sendMail(Visite visite) {
		String mailRecup = visite.getClient().getMail();
		Client cl = visite.getClient();
		BienImmobilier bien = visite.getBienImmo();
		Adresse adresse = bien.getAdresse();
		String adresse2 = adresse.getNumero() + ", " + adresse.getRue() + "<br/>" + adresse.getCodePostal() + " " + adresse.getLocalite();
//		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyyy");
//		SimpleDateFormat dt2 = new SimpleDateFormat("hh:mm");

		// TODO Auto-generated method stub
		final String username = "clear.skies928@gmail.com";
		final String password = /* Ne soyez pas trop curieux ! */ 																																												"BubblyClouds8";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// Get Session object.
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {

			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);
			Multipart multipart = new MimeMultipart();

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailRecup));

			// Set Subject: header field
			message.setSubject("Visite programée pour le bien n°" + bien.getId() + " à " + visite.getDate());

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(
					"Bonjour M. ou Mme " + cl.getNom() + ",<br/> "
					+ "La visite pour le bien n° " + bien.getId() + " le " + visite.getDate() + " à " + visite.getHeure() + "a bien été prise en compte par nos services.<br/>"
							+ "Pour rappel, celui-ci se situe au : <br/>"
							+  adresse2
							+ "<br/>Veuillez trouver ci-joint le récapitulatif du bien proposé.<br/><br/>"
							+ "En cas d'imprévu pour cette visite, nous vous recontacterons par téléphone pour fixer un nouveau rendez-vous. Vous pouvez également appeler nos services par téléphone ou vous déplacer en centre pour modifier ce rendez-vous."
							+ "En esperant vous revoir bientôt dans notre centre, <br/> " + "Jean-Michel Scrum Immobilier",
					"text/html");

			// creates body part for the attachment
			MimeBodyPart attachPart = new MimeBodyPart();
			
			// ajouter la PJ
			String attachFile = getFile(visite.getBienImmo().getId());

			DataSource source = new FileDataSource(attachFile);
			attachPart.setDataHandler(new DataHandler(source));
			attachPart.setFileName(new File(attachFile).getName());

			// adds parts to the multipart
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(attachPart);

			// sets the multipart as message's content
			message.setContent(multipart);

			// Send message
			Transport.send(message, message.getAllRecipients());
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		// TODO Auto-generated method stub
	}

	@Override
	public void sendMail2(Visite visite) {
		String mailRecup = visite.getClient().getMail();
		Client cl = visite.getClient();
		BienImmobilier bien = visite.getBienImmo();
		Adresse adresse = bien.getAdresse();
		String adresse2 = adresse.getNumero() + ", " + adresse.getRue() + "<br/>" + adresse.getCodePostal() + " " + adresse.getLocalite();
//		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyyy");
//		SimpleDateFormat dt2 = new SimpleDateFormat("hh:mm");

		// TODO Auto-generated method stub
		final String username = "clear.skies928@gmail.com";
		final String password = /* Ne soyez pas trop curieux ! */ 																																												"BubblyClouds8";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// Get Session object.
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {

			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);
			Multipart multipart = new MimeMultipart();

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailRecup));

			// Set Subject: header field
			message.setSubject("Visite déplacée au " + visite.getDate() + " - " + visite.getHeure() + " pour le bien n°" + bien.getId());

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(
					"Bonjour M. ou Mme " + cl.getNom() + ",<br/> "
					+ "La visite pour le bien n° " + bien.getId() + " a été déplacée au " + visite.getDate() + " à " + visite.getHeure() + ".<br/>"
							+ "Pour rappel, celui-ci se situe au : <br/>"
							+  adresse2
							+ "<br/>Veuillez trouver ci-joint le récapitulatif du bien proposé.<br/><br/>"
 							+ "En cas d'imprévu pour cette visite, nous vous recontacterons par téléphone pour fixer un nouveau rendez-vous. Vous pouvez également appeler nos services par téléphone ou vous déplacer en centre pour modifier ce rendez-vous."
							+ "En esperant vous revoir bientôt dans notre centre, <br/> " + "Jean-Michel Scrum Immobilier",
					"text/html");

			// creates body part for the attachment
			MimeBodyPart attachPart = new MimeBodyPart();
			
			// ajouter la PJ
			String attachFile = getFile(visite.getBienImmo().getId());

			DataSource source = new FileDataSource(attachFile);
			attachPart.setDataHandler(new DataHandler(source));
			attachPart.setFileName(new File(attachFile).getName());

			// adds parts to the multipart
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(attachPart);

			// sets the multipart as message's content
			message.setContent(multipart);

			// Send message
			Transport.send(message, message.getAllRecipients());
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		// TODO Auto-generated method stub
		

	}

}
