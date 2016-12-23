package org.lf.yydp.service.film;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.lf.yydp.db.dao.PlanMapper;
import org.lf.yydp.db.dao.SeatsMapper;
import org.lf.yydp.db.pojo.Plan;
import org.lf.yydp.db.pojo.Seats;
import org.lf.yydp.service.model.MovieInfo;
import org.lf.yydp.service.model.TicketItemDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("buyTicketService")
public class BuyTicketService {
	
	@Autowired
	private SeatsMapper seatsDao;
	
	@Autowired
	private PlanMapper planDao;
	/**
	 * 鍔熻兘:寰楀埌鎵�湁搴т綅鐨剆tatus鐨勬暟缁�
	 * @return
	 */
	public Integer[] getSeatsArray (Integer planId) {
		Integer[] statusList= new Integer[100];
		List<Seats> seatsList = seatsDao.getOrderedSeatsByPlanId(planId);
		for (int i=0;i<statusList.length;i++) {
			statusList[i]=0;
		}
		for (Seats seat:seatsList) {
			statusList[seat.getSeatId()-1]=1;
		}
		return statusList;
	}
	/**
	 * 鍔熻兘:鏍规嵁浼犺繘鏉ョ殑f_id寰楀埌瀵瑰簲鐨勭數褰辨秷鎭�
	 * @return
	 * @throws ParseException 
	 */
	public MovieInfo getMovieInfo (Integer plan_id) {
		return seatsDao.getMvieInfoByPid(plan_id);
	}

	/**
	 * 功能:发邮件
	 * @param receiver
	 */
	public void sendEmail (String receiver) {
		Properties p = null;
		InputStream inputSteam = null;
		String senter = null;
		String Subject = null;
		String Content = null;
		try {
			p = new Properties();
			inputSteam = BuyTicketService.class.getClassLoader().getResourceAsStream("mail.properties");
			p.load(inputSteam);
			final String uname = p.getProperty("mail.uname");
			final String license = p.getProperty("mail.license");
			senter = p.getProperty("mail.senter");
			Subject = p.getProperty("mail.subject");
			Content = p.getProperty("mail.content");
			Authenticator authenticator = new Authenticator() {
				@Override
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(uname, license);
				}
			}; 
			Session session = Session.getInstance(p,authenticator);
			
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(senter));
			msg.setRecipient(RecipientType.TO,new InternetAddress(receiver));
			msg.setSubject(Subject);
			msg.setContent(Content, "text/html;charset=utf-8");
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputSteam!=null){
					inputSteam.close();
				}	
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
	
	
	public List<TicketItemDataModel> getPlanList(Integer f_id){
		return convert(planDao.slectPlanByF_id(f_id));
	}
	
	/**
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 表示24小时的
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 表示12小时的
	 * @param planList
	 * @return
	 */
	private List<TicketItemDataModel> convert(List<Plan> planList){
		List<TicketItemDataModel> listModel = new ArrayList<TicketItemDataModel>();
		TicketItemDataModel model = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(Plan plan : planList){
			model = new TicketItemDataModel();
			model.setPlay_time(sdf.format(plan.getPlayTime()));
			model.setPh_id(plan.getPhId().toString());
			model.setPlan_id(plan.getId().toString());
			listModel.add(model);
		}
		return listModel;
	}
	
	public Plan getPlanById(Integer id){
		return planDao.slectPlanByplan_id(id);
	}
}
