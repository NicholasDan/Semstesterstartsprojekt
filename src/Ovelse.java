public class Ovelse {
    private int ovelseTid;
    private String ovelse;
    private String gentagelser;



    public Ovelse(int tid_min, String ovelse) {
        this.ovelse = ovelse;
        this.ovelseTid = tid_min;
    }


    public int getOvelseTid() {
        return ovelseTid;
    }



    public String getOvelse() {
        return ovelse;
    }



    public void setOvelse(String ovelse) {
        this.ovelse = ovelse;
    }

    public void setOvelseTid(int ovelseTid) {
        this.ovelseTid = ovelseTid;
    }
}