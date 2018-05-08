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
	 * 모든 사용자에게 메시지를 전달한다.
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
				if(strArr[0].contains("회사소개") || strArr[0].contains("회사 소개")) {
					session.getBasicRemote().sendText("rnbsoft $$ <h1>알앤비소프트 회사소개</h1><br>"
							+ "알앤비소프트는 통신 빌링시스템으로 시작으로 다양한 영역으로 회사를 확장해 나가고 있습니다. $$ resources/images/rnbchatmark.jpg");
				}else if(strArr[0].contains("오늘 날씨") || strArr[0].contains("오늘날씨")) {
					if(strArr[0].contains("알려줘") ||strArr[0].contains("말해줘")) {
						String URL = "https://weather.naver.com/rgn/cityWetrMain.nhn";
				        Document doc = Jsoup.connect(URL).get();
				        Elements elem = doc.select(".tbl_weather tbody>tr:nth-child(1)");
				        String[] str = elem.text().split(" ");
				        Elements elem2=doc.select(".tbl_weather tbody>tr:nth-child(1) img");
				        
						session.getBasicRemote().sendText("rnbsoft $$ <h1>오늘의 날씨</h1><br>"
								+str[0]+" 혹은 "+str[1]+"지역의 오전 날씨는 "+elem2.get(0)+str[2]+"이며, "+str[3]+"은 "+str[4]+" 이고 "+str[5]+"은 "+str[6]+"입니다."
										+"<br>"+" 오후 날씨는 "+elem2.get(1)+str[7]+"이며, "+str[8]+"은 "+str[9]+" 이고 "+str[10]+"은 "+str[11]+"입니다. $$ resources/images/rnbchatmark.jpg");
					}else if(strArr[0].contains("말하지마")|| strArr[0].contains("알려주지마")) {
						session.getBasicRemote().sendText("rnbsoft $$ 오늘 날씨가 궁금하지 않으시군요... $$ resources/images/rnbchatmark.jpg");
					}else {
						String URL = "https://weather.naver.com/rgn/cityWetrMain.nhn";
				        Document doc = Jsoup.connect(URL).get();
				        Elements elem = doc.select(".tbl_weather tbody>tr:nth-child(1)");
				        String[] str = elem.text().split(" ");
				        Elements elem2=doc.select(".tbl_weather tbody>tr:nth-child(1) img");
				        
						session.getBasicRemote().sendText("rnbsoft $$ <h1>오늘의 날씨</h1><br>"
								+str[0]+" 혹은 "+str[1]+"지역의 오전 날씨는 "+elem2.get(0)+str[2]+"이며, "+str[3]+"은 "+str[4]+" 이고 "+str[5]+"은 "+str[6]+"입니다."
										+"<br>"+" 오후 날씨는 "+elem2.get(1)+str[7]+"이며, "+str[8]+"은 "+str[9]+" 이고 "+str[10]+"은 "+str[11]+"입니다. $$ resources/images/rnbchatmark.jpg");
					}
				}else if( strArr[0].contains("내일날씨") || strArr[0].contains("내일 날씨")) {
					session.getBasicRemote().sendText("rnbsoft $$ 제가 예언자도 아니고...오늘 날씨 밖에 몰라요. $$ resources/images/rnbchatmark.jpg");
					
				}else if(strArr[0].contains("앤비야")) {
					session.getBasicRemote().sendText("rnbsoft $$ 왜 부르세요? 궁금하신게 있으신가요?..저는 회사소개와 오늘 날씨 밖에 몰라요... $$ resources/images/rnbchatmark.jpg");
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
