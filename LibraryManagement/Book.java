class Book{
    private int id;
    private String title;
    private Boolean isIssued;
    
    Book(int id, String title, Boolean isIssued){
        this.id = id;
        this.title = title;
        this.isIssued = isIssued;
    }

    public String getBookTitle(){
        return title;
    }

    public int getBookId(){
        return id;
    }

    public Boolean getIsIssued(){
        return isIssued;
    }

    public void setIsIssued(Boolean b){
        isIssued = b;
    }

}