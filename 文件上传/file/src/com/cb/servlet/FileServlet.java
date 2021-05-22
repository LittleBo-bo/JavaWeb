package com.cb.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

public class FileServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   //判断上传的文件是普通表单还是带文件的表单
        if(!ServletFileUpload.isMultipartContent(request)){
            return;  //终止方法运行  这是一个普通表单 直接返回
        }

        //创建上传文件的保存路径，在WEB-INF路径下，用户无法访问上传的文件
        String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(uploadPath);
        if(!file.exists()){
            file.mkdir();//创建这个目录
        }
        //1创建DiskFileItemFactory对象 处理文件上传路径或者大小限制
        DiskFileItemFactory factory = getDiskFileItemFactory(file);
        //2获得ServletFileUpload
        ServletFileUpload upload = getServletFileUpload(factory);
        //3处理上传的文件
        String msg = uploadParseRequest(upload,request,uploadPath);

        request.setAttribute("msg",msg);
        request.getRequestDispatcher("info.jsp").forward(request,response);
    }
    public static DiskFileItemFactory getDiskFileItemFactory(File file){
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //通过这个工厂设置一个缓冲区，当上传的文件大于这个缓冲区时，放到临时文件中
        factory.setSizeThreshold(1024*1024);//缓存大小为1M
        factory.setRepository(file); //临时保存的目录，需要一个file
        return factory;
    }

    public static ServletFileUpload getServletFileUpload(DiskFileItemFactory factory){
        //2获取ServletFileUpload
        ServletFileUpload upload = new ServletFileUpload(factory);

        //监听文件上传进度
        upload.setProgressListener(new ProgressListener() {
            // l:已经读取到文件的大小
            //o:文件大小
            @Override
            public void update(long l, long o, int i) {
                System.out.println("总大小："+o+" 已上传："+l);
            }
        });
        //处理乱码问题
        upload.setHeaderEncoding("utf-8");
        //设置单个文件最大值
        upload.setFileSizeMax(1024*1024*10);
        //设置总共能够上传文件的大小  10M
        upload.setSizeMax(1024*1024*10);
        return upload;
    }


    public  static String uploadParseRequest(ServletFileUpload upload,HttpServletRequest request, String uploadPath){
        String msg = "";
        //3、处理上传文件
        //把前端请求解析，封装成一个FileItem对象 需要从ServletFileUpload对象中获取
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                //判断上传的文件是普通表单还是带文件的表单
                if(fileItem.isFormField()){
                    //getFieldName指的时前端表单控件的name
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("utf-8");//处理乱码
                    System.out.println(name+":"+value);
                }else{
                    //处理文件
                    String uploadfileName = fileItem.getName();
                    //如果文件名不合法
                    System.out.println("上传的文件名："+uploadfileName);
                    if(uploadfileName.trim().equals("")||uploadfileName==null){
                        continue;
                    }
                    //获得上传的文件名 /image/girl/paojie.png
                    String fileName = uploadfileName.substring(uploadfileName.lastIndexOf("/") + 1);
                    //获取文件的后缀名
                    String fileExtname = uploadfileName.substring(uploadfileName.lastIndexOf(".") + 1);


                    //使用UUID
                    String uuidPath = UUID.randomUUID().toString();


                    //存放地址

                    //文件真实存在路径 realPath
                    String realPath = uploadPath+"/"+uuidPath;
                    //给每个文件创建一个对应的文件夹
                    File realPathFile = new File(realPath);
                    if(!realPathFile.exists()){
                        realPathFile.mkdir();
                    }

                    //文件传输完毕
                    //获得文件上传的流
                    InputStream inputStream = fileItem.getInputStream();
                    //创建一个文件输出流
                    //realPath = 真实文件夹
                    //差了一个文件，加上输出文件的名字+“/”+uuidFileName
                    FileOutputStream fos = new FileOutputStream(realPath + "/" + fileName);

                    //创建一个缓冲区
                    byte[] buffer = new byte[1024*1024];

                    //判断是否读取完毕
                    int len = 0;
                    while((len=inputStream.read(buffer))>0){
                        fos.write(buffer,0,len);
                    }
                    //关闭流
                    fos.close();
                    inputStream.close();
                    msg = "文件上传成功";
                    fileItem.delete();//上传成功，清除临时文件
                }
            }

        } catch (FileUploadException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }




























      /*
        //缓存，临时文件
        //临时路径，假如文件超过了预期大小，我们就把他放到一个临时文件中，过几天自动删除，或者提醒用户转为永久
        String tmpPath = this.getServletContext().getRealPath("/WEB-INF/tmp");
        File tmpFile = new File(tmpPath);
        if(!tmpFile.exists()){
            tmpFile.mkdir();//创建这个目录
        }
        //使用Apache的文件上传组件来实现， common-fileupload 需要commons-io组件


        //1.创建DiskFileItemFactory对象，处理文件上传路径或者大小的限制
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //通过这个工厂设置一个缓冲区，当上传的文件大于这个缓冲区时，放到临时文件中
        factory.setSizeThreshold(1024*1024);//缓存大小为1M
        factory.setRepository(tmpFile); //临时保存的目录，需要一个file

        //2获取ServletFileUpload
        ServletFileUpload upload = new ServletFileUpload(factory);

        //监听文件上传进度
        upload.setProgressListener(new ProgressListener() {
            // l:已经读取到文件的大小
            //o:文件大小
            @Override
            public void update(long l, long o, int i) {
                System.out.println("总大小："+o+" 已上传："+l);
            }
        });
        //处理乱码问题
        upload.setHeaderEncoding("utf-8");
        //设置单个文件最大值
        upload.setFileSizeMax(1024*1024*10);
        //设置总共能够上传文件的大小  10M
        upload.setSizeMax(1024*1024*10);


        //3、处理上传文件
        //把前端请求解析，封装成一个FileItem对象 需要从ServletFileUpload对象中获取
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                //判断上传的文件是普通表单还是带文件的表单
                if(fileItem.isFormField()){
                    //getFieldName指的时前端表单控件的name
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("utf-8");//处理乱码
                    System.out.println(name+":"+value);
                }else{
                    //处理文件
                    String uploadfileName = fileItem.getName();
                    //如果文件名不合法
                    if(uploadfileName.trim().equals("")||uploadfileName==null){
                        continue;;
                    }
                    //获得上传的文件名 /image/girl/paojie.png
                    String fileName = uploadfileName.substring(uploadfileName.lastIndexOf("/") + 1);
                    //获取文件的后缀名
                    String fileExtname = uploadfileName.substring(uploadfileName.lastIndexOf(".") + 1);


                    //使用UUID
                    String uuidPath = UUID.randomUUID().toString();


                    //存放地址

                    //文件真实存在路径 realPath
                    String realPath = uploadPath+"/"+uuidPath;
                    //给每个文件创建一个对应的文件夹
                    File realPathFile = new File(realPath);
                    if(!realPathFile.exists()){
                        realPathFile.mkdir();
                    }

                    //文件传输完毕
                    //获得文件上传的流
                    InputStream inputStream = fileItem.getInputStream();
                    //创建一个文件输出流
                    //realPath = 真实文件夹
                    //差了一个文件，加上输出文件的名字+“/”+uuidFileName
                    FileOutputStream fos = new FileOutputStream(realPath + "/" + fileName);

                    //创建一个缓冲区
                    byte[] buffer = new byte[1024*1024];

                    //判断是否读取完毕
                    int len = 0;
                    while((len=inputStream.read(buffer))>0){
                        fos.write(buffer,0,len);
                    }
                    //关闭流
                    fos.close();
                    inputStream.close();
                    msg = "文件上传成功";
                    fileItem.delete();//上传成功，清除临时文件

                }
                return msg;
            }





        } catch (FileUploadException e) {
            e.printStackTrace();
        }*/


    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

    }
}
