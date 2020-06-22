package com.study.controller.gboard;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.study.commons.file.FileManager;
import com.study.model.gboard.GBoard;
import com.study.model.gboard.GBoardDAO;

//JSP가 서블릿이라는 원칙을 잊지 않기 위해!!
public class UploadServlet extends HttpServlet{
	
	GBoardDAO gboardDAO = new GBoardDAO();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post요청 받음!!");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//itemFactory를 이용하면 저장경로. 파일사이즈 재한...
		DiskFileItemFactory itemFactory = new DiskFileItemFactory();
		
		//application내장객체의 자료형
		ServletContext context = request.getServletContext();//application 내장객체의 자료형
		String savePath=context.getRealPath("/data");
		System.out.println("저장경로는"+savePath);
		File saveDir = new File(savePath);
		int maxSize = 3*1024*1024;
		itemFactory.setRepository(saveDir);//저장 경로 지정
		//파일 사이즈 제한
		itemFactory.setSizeThreshold(maxSize);
		ServletFileUpload upload = new ServletFileUpload(itemFactory);
		
		//업로드 시작!!
		try {
			//클라이언트가 html지정한 컴포넌트들이 List로 반환
			//html 컴포넌트들을 FileItem 으로 처리함!
			List<FileItem> itemList = upload.parseRequest(request);
			System.out.println("넘어온 파라미터 수는 " + itemList.size());
			//파라미터 추출하기!!
			
			//넘겨받은 파라미터들중에 파일관련한 파라미터와 텍스트데이터
			//파라미터를 구분해내야 한다!!
			//VO준비!
			GBoard gboard = new GBoard();
			
			for(int i=0;i<itemList.size();i++ ) {
				FileItem item = itemList.get(i);
				if(item.isFormField()){//데이터베이스에 넣을처리					
					System.out.println(item.getFieldName());
					
					if(item.getFieldName().equals("title")) {
						gboard.setTitle(item.getString("utf-8"));						
					}else if(item.getFieldName().equals("writer")) {
						gboard.setWriter(item.getString("utf-8"));
					}
				}else {
					System.out.println(item.getFieldName());
					//파일명을 바꿔야 하므로, 업로드된 파일명부터 추출!
					String ori = item.getName();
					System.out.println("업로드된 원래 파일명은"+ori);
					String dest = FileManager.getFileRename(ori);
					gboard.setFilename(dest);
					
					//서버에 저장!!
					File destFile = new File(savePath+"/"+dest);
					item.write(destFile);					
				}
				//파일컴포넌트가 아닌 일반컴포넌트
			}		
			System.out.print("제목"+gboard.getTitle()+"업로드 성공!");
			int result = gboardDAO.insert(gboard);
			
			if(result !=0) {
				out.print("<script>");
				out.print("alert('등록성공')");
				out.print("location.href='/gboard/list.jsp';");
				out.print("</script>");
			}else {
				out.print("<script>");
				out.print("alert('등록실패')");
				out.print("history.back();");
				out.print("</script>");
			}
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}









