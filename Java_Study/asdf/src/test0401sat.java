//import java.io.*;
//import java.util.ArrayList;
//
//import kr.or.team4.Movie;
//
//public class FileIO implements Serializable{
//   public void Output() {
//      ArrayList<Movie> movielist = new ArrayList<Movie>();
//      
//      
//      FileOutputStream fos = null;
//      BufferedOutputStream bos = null;
//      ObjectOutputStream out=null;
//      
//      
//      
//      
//      
//      
//      try {
//         fos = new FileOutputStream("C:\\Team4\\JavaPrj\\Cinema\\movie.txt");
//         bos = new BufferedOutputStream(fos);
//         out = new ObjectOutputStream(bos);
//         
//         movielist.add(new Movie("Ω∫¡Ó∏ﬁ", 10000));
//         movielist.add(new Movie("¡∏¿®4", 12000));
//         out.writeObject(movielist);
//            
//      } catch (Exception e) {
//               e.getStackTrace();
//      } finally {
//         try {
//            out.close();
//            bos.close();
//            fos.close();
//         } catch (Exception e) {
//            e.printStackTrace();
//         }
//      }
//      
//      
//      
//   
//   }
//}