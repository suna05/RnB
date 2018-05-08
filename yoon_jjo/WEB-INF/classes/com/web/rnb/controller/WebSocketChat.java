package com.web.rnb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.ServerEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.rnb.chat.ChatDTO;
import com.web.rnb.chat.ChatService;
import com.web.rnb.member.MemberAndPhotoDTO;
import com.web.rnb.member.MemberDTO;
import com.web.rnb.member.MemberService;
import com.web.rnb.photo.ProfilePhotoDTO;
import com.web.rnb.photo.ProfilePhotoService;

import javax.websocket.RemoteEndpoint.Basic;

@Controller
@ServerEndpoint(value="/echo.do")
public class WebSocketChat {
	
	@Autowired
	ProfilePhotoService ppService;
	@Autowired
	MemberService memberService;
	@Autowired
	ChatService chatService;
	
	private static final List<Session> sessionList=new ArrayList<Session>();;
	private static final Logger logger = LoggerFactory.getLogger(WebSocketChat.class);
	
	@RequestMapping(value="/chat.do")
	public ModelAndView getChatViewPage(ModelAndView mav) {
		List<ChatDTO> list=chatService.getListChat();
		logger.info("chatList size: "+list.size());
		mav.addObject("chatList",list);
		mav.setViewName("chat");
		return mav;
	}
	@ResponseBody
	@RequestMapping(value="/chatWrite.do")
	public int insertChat(ChatDTO cdto) {
		logger.info(cdto.toString());
		chatService.insertChat(cdto);
		return 1;
	}
	@OnOpen
	public void onOpen(Session session) {
		logger.info("Open session id:"+session.getId());
		/*try {
			final Basic basic=session.getBasicRemote();
			basic.sendText("Connection Established");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}*/
		sessionList.add(session);
	}
	/*
	 * ��� ����ڿ��� �޽����� �����Ѵ�.
	 * @param self
	 * @param message
	 */
	private void sendAllSessionToMessage(Session self,String message) {
		String[] strArr=message.split(":");
		try {
			for(Session session : WebSocketChat.sessionList) {
				if(!self.getId().equals(session.getId())) {
					session.getBasicRemote().sendText(strArr[1]+" $$ "+strArr[0]+" $$ "+strArr[2]);
				}
			}
			for(Session session : WebSocketChat.sessionList) {
				if(strArr[0].contains("ȸ��Ұ�") || strArr[0].contains("ȸ�� �Ұ�")) {
					session.getBasicRemote().sendText("rnbsoft $$ <h1>�˾غ����Ʈ ȸ��Ұ�</h1><br>"
							+ "�˾غ����Ʈ�� ��� �����ý������� �������� �پ��� �������� ȸ�縦 Ȯ���� ������ �ֽ��ϴ�. $$ resources/images/rnbchatmark.jpg");
				}else if(strArr[0].contains("���� ����") || strArr[0].contains("���ó���")) {
					if(strArr[0].contains("�˷���") ||strArr[0].contains("������")) {
						String URL = "https://weather.naver.com/rgn/cityWetrMain.nhn";
				        Document doc = Jsoup.connect(URL).get();
				        Elements elem = doc.select(".tbl_weather tbody>tr:nth-child(1)");
				        String[] str = elem.text().split(" ");
				        Elements elem2=doc.select(".tbl_weather tbody>tr:nth-child(1) img");
				        
						session.getBasicRemote().sendText("rnbsoft $$ <h1>������ ����</h1><br>"
								+str[0]+" Ȥ�� "+str[1]+"������ ���� ������ "+elem2.get(0)+str[2]+"�̸�, "+str[3]+"�� "+str[4]+" �̰� "+str[5]+"�� "+str[6]+"�Դϴ�."
										+"<br>"+" ���� ������ "+elem2.get(1)+str[7]+"�̸�, "+str[8]+"�� "+str[9]+" �̰� "+str[10]+"�� "+str[11]+"�Դϴ�. $$ resources/images/rnbchatmark.jpg");
					}else if(strArr[0].contains("��������")|| strArr[0].contains("�˷�������")) {
						session.getBasicRemote().sendText("rnbsoft $$ ���� ������ �ñ����� �����ñ���... $$ resources/images/rnbchatmark.jpg");
					}else {
						String URL = "https://weather.naver.com/rgn/cityWetrMain.nhn";
				        Document doc = Jsoup.connect(URL).get();
				        Elements elem = doc.select(".tbl_weather tbody>tr:nth-child(1)");
				        String[] str = elem.text().split(" ");
				        Elements elem2=doc.select(".tbl_weather tbody>tr:nth-child(1) img");
				        
						session.getBasicRemote().sendText("rnbsoft $$ <h1>������ ����</h1><br>"
								+str[0]+" Ȥ�� "+str[1]+"������ ���� ������ "+elem2.get(0)+str[2]+"�̸�, "+str[3]+"�� "+str[4]+" �̰� "+str[5]+"�� "+str[6]+"�Դϴ�."
										+"<br>"+" ���� ������ "+elem2.get(1)+str[7]+"�̸�, "+str[8]+"�� "+str[9]+" �̰� "+str[10]+"�� "+str[11]+"�Դϴ�. $$ resources/images/rnbchatmark.jpg");
					}
				}else if( strArr[0].contains("���ϳ���") || strArr[0].contains("���� ����")) {
					session.getBasicRemote().sendText("rnbsoft $$ ���� �����ڵ� �ƴϰ�...���� ���� �ۿ� �����. $$ resources/images/rnbchatmark.jpg");
					
				}else if(strArr[0].contains("�غ��")) {
					session.getBasicRemote().sendText("rnbsoft $$ �� �θ�����? �ñ��ϽŰ� �����Ű���?..���� ȸ��Ұ��� ���� ���� �ۿ� �����... $$ resources/images/rnbchatmark.jpg");
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	@OnMessage
	public void onMessage(String message,Session session) {
		logger.info("Message From "+message);
		String[] strArr=message.split(":");
		try {
			final Basic basic=session.getBasicRemote();
			basic.sendText(strArr[1]+"$$"+strArr[0]);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		sendAllSessionToMessage(session, message);
	}
	@OnError
	public void onError(Throwable e,Session session) {
		
	}
	@OnClose
	public void onClose(Session session) {
		logger.info("Session "+session.getId()+" has ended");
		sessionList.remove(session);
	}
}
