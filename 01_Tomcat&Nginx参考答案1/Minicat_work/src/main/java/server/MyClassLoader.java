package server;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;

public class MyClassLoader extends ClassLoader {
  
    /** 
     * name class 类的绝对路径
     */  
    @Override  
    protected Class<?> findClass(String basePath,String name)  {
        //System.out.println("basePath:"+basePath);
        //System.out.println("name:"+name);
        //String myPath = "file://" + basePath +  name.replaceAll("\\.","/") + ".class";
        //System.out.println("name2:"+name.replaceAll("\\.", Matcher.quoteReplacement(File.separator)));
        String myPath = basePath +  name.replaceAll("\\.", Matcher.quoteReplacement(File.separator)) + ".class";
        System.out.println("myPath:"+myPath);
        //String path2 = "D:\\mytomcat\\webapps\\demo1\\server\\LagouServlet.class";
        //System.out.println("path2:"+path2);
        byte[] cLassBytes = null;
        Path path = null;
        try {
            path = Paths.get(myPath);
            cLassBytes = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class clazz = defineClass(name, cLassBytes, 0, cLassBytes.length);
        return clazz;
    }

 /*   public static void main(String[] args) {
        String path2 = "D://mytomcat//webapps//demo1//server//LagouServlet.class";
        Path path = null;
        byte[] cLassBytes = null;
        try {//Path path = Paths.get("C:\\home\\joe\\foo");
            path = Paths.get("D:\\mytomcat\\webapps\\demo1\\server\\LagouServlet.class");
            cLassBytes = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Class clazz = defineClass(name, cLassBytes, 0, cLassBytes.length);

    }*/


}  