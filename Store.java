import java.util.ArrayList;

public class Store {
    private ArrayList<Movie> movies;

    public Store(){
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index){
        return new Movie(this.movies.get(index));
    }

    //Using this method to check if a movie that was passed in is available or not.
    public Movie getMovie(String name){
        for (int i = 0; i < this.movies.size(); i++) {
            if(this.movies.get(i).getName().equals(name)){
                return new Movie(this.movies.get(i));
            }
        }
        return null;
    }

    public boolean contains(Movie movie){
        return this.movies.contains(movie);
    }

    //had to improvise with a for loop here because the tutorial method does not make sense to me.
    public void sellMovie(String name){
      for (int i = 0; i < this.movies.size(); i++){
        if(this.movies.get(i).getName().equals(name) && this.movies.get(i).getIsAvailable() == false){
            throw new IllegalStateException("Cannot sell rented movies");
        }
      }
     this.movies.removeIf((movie) ->  movie.getName().equals(name));
    }

    public void rentMovie(String name){
        this.movies.stream()
        .filter((movie) -> movie.getName().equals(name))
        .forEach((movie) -> movie.setIsAvailable(false));
    }

    public void returnMovie(String name){
        this.movies.stream()
        .filter((movie) -> movie.getName().equals(name))
        .forEach((movie) -> movie.setIsAvailable(true));
    }

    public void setMovie(int index, Movie movie){
        this.movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie){
        this.movies.add(new Movie(movie));
    }

    public void action(String name, String action){

        if(!(action.equals("sell") || action.equals("rent") || action.equals("return"))){
            throw new IllegalArgumentException("Must either be sell, rent, and return");
        }

        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        if(this.movies.isEmpty()){
            throw new IllegalStateException("Store is empty.");
        }

        for (int i = 0; i < this.movies.size(); i++) {
            if(this.movies.get(i).getName().equals(name)){
            switch(action){
                case "sell" :  
                if(!(movies.get(i).getIsAvailable())){
                    throw new IllegalStateException("Cannot sell a movie that is rented");
                }
                 this.movies.remove(i) ; break;
                case "rent" :    this.movies.get(i).setIsAvailable(false) ; break;
                case "return" :  this.movies.get(i).setIsAvailable(true) ;  break;
                }
            }
        }
     
    }

    public String toString(){
        String temp = "";
        for (int i = 0; i < this.movies.size(); i++) {
           temp +=  this.movies.get(i).toString();
           temp += "\n\n";
        }
        return temp;
    }

}
