package Work.Account;



public class URL {
    private String url;
    private String type;
    private  Account account;

    public URL(String url,String type, Account account)
    {
        setUrl(url);
        setType(type);
        setAccount(account);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    public String toString(){
        return "URL - "+getUrl()+" Type: "+getType()+"\n"+getAccount()+"\n\n";
    }
}
