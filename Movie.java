public class Movie{
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;


    public Movie(String name, String format, double rating) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if(!(format.equals("DVD") || format.equals("Blue-Ray"))){
            throw new IllegalArgumentException("Format must either be DVD or Blue-ray");
        }
        if(rating < 0 || rating > 10){
            throw new IllegalArgumentException("Rating cannot be less zero or greater than 10");
        }
      
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.isAvailable = true;
        this.sellingPrice = format.equals("Blue-Ray") ? 4.25 : 2.25;
        this.rentalPrice = format.equals("Blue-Ray") ? 1.99 : 0.99;
        this.isAvailable = true;
    }
    public Movie(Movie source){
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.sellingPrice = source.sellingPrice;
        this.rentalPrice = source.rentalPrice;
        this.isAvailable = source.isAvailable;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        if(!(format.equalsIgnoreCase("DVD") || format.equalsIgnoreCase("Blue-Ray"))){
            throw new IllegalArgumentException("Format must either be DVD or Blue-ray");
        }
        if(rating < 0 || rating > 10){
            throw new IllegalArgumentException("Rating cannot be less zero or greater than 10");
        }
        // setSellingPrice(format.equals("Blue-Ray") ? 4.25 : 2.25);
        this.format = format;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        if(rating < 0 || rating > 10){
            throw new IllegalArgumentException("Rating cannot be less zero or greater than 10");
        }
        this.rating = rating;
    }

    public double getSellingPrice() {
        return this.sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getRentalPrice() {
        return this.rentalPrice;
    }

    private void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public String isIsAvailable() {
        if(getIsAvailable() == true){
            return "In-stock";
        }else{
            return "Rented";
        }
       
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String toString(){
        return "\t Name: " + this.name + "\n" +
        "\t Format: " + this.format + "\n" + 
        "\t Rating: " + this.rating + "\n" +
        "\t Selling Price: " + this.sellingPrice + "\n" +
        "\t Rental Price: " + this.rentalPrice + "\n" 
        +   "\t Availability: " + isIsAvailable();
    }

    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Movie)){
            return false;
        }
        Movie movie = (Movie)obj;
        return this.name.equals(movie.name) && 
        this.format.equals(movie.format) &&
        this.rating == movie.rating &&
        this.sellingPrice == movie.sellingPrice &&
        this.rentalPrice == movie.rentalPrice &&
        this.isAvailable == movie.isAvailable;
    }

}