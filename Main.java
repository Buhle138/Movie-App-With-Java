import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.*;

public class Main {
    static Store store = new Store();
    public static void main(String[] args) {

        while(true){
            try{
                loadMovies("Movies.txt");
                manageMovies();

            }catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            }finally{
                System.out.println("Process complete");
            }
        }
   
    }


    public static void manageMovies(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("\nWould you like to \n\ta) purchase\n\tb) rent \n\tc) return \n\td) exit");
            String choice = input.nextLine();
            switch(choice){
                case "a": System.out.print("Enter the name of the movie you would like to purchase:  "); 
                String nameOfMovie = input.nextLine();
                if(nameOfMovie == null || nameOfMovie.isBlank() || store.getMovie(nameOfMovie) == null){
                    System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                    continue;
                }
                if(!(store.getMovie(nameOfMovie).getIsAvailable())){
                    System.out.println("The movie is rented");
                    continue;
                }
                store.action(nameOfMovie, "sell");
                System.out.println("\n\nUPDATED MOVIES\n\n");
                System.out.println(store);
                continue;
                case "b" : System.out.print("Enter the name of the movie you would like to rent:  ");
                String rentMovie = input.nextLine();
                if(rentMovie == null || rentMovie.isBlank() || store.getMovie(rentMovie) == null){
                    System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                    continue;
                }
                store.action(rentMovie, "rent");
                System.out.println("\n\nUPDATED MOVIES\n\n");
                System.out.println(store);
                continue;
                case "c" : System.out.print("Enter the name of the movie you would like to return:  ");
                String returnMovie = input.nextLine();
                if(returnMovie == null || returnMovie.isBlank() || store.getMovie(returnMovie) == null){
                    System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                    continue;
                }
                store.action(returnMovie, "return");
                System.out.println("\n\nUPDATED MOVIES\n\n");
                System.out.println(store);
                continue;
                case "d" : return;
            }
        }
       
    }



    public static void loadMovies(String file) throws FileNotFoundException{
        FileInputStream input = new FileInputStream(file);
        Scanner scan = new Scanner(input);

        /*This while loop acts like a for loop it goes it loops through line by line. */
        while(scan.hasNextLine()){
            String[] items = scan.nextLine().split("--");
           Double rating =  Double.parseDouble(items[2]);
              Movie movies = new Movie(items[0], items[1], rating);
              store.addMovie(movies);
        }
        System.out.println(store);
    }
}
