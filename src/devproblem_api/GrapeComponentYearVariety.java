package devproblem_api;

public class GrapeComponentYearVariety implements Comparable {
    private int year;
    private String variety;

    public GrapeComponentYearVariety(int year, String variety) {
        this.year = year;
        this.variety = variety;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrapeComponentYearVariety that = (GrapeComponentYearVariety) o;

        if (year != that.year) return false;
        return variety != null ? variety.equals(that.variety) : that.variety == null;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + (variety != null ? variety.hashCode() : 0);
        return result;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    @Override
    public int compareTo(Object o) {
        if (this.equals(o)) {
            return 0;
        } else {
            GrapeComponentYearVariety that = (GrapeComponentYearVariety) o;
            if (that.getYear() != this.year) {
                return that.getYear() - this.getYear();
            } else {
                return that.getVariety().compareTo(this.getVariety());
            }
        }
    }

    @Override
    public String toString() {
        return "GrapeComponentYearVariety{" +
                "year=" + year +
                ", variety='" + variety + '\'' +
                '}';
    }
}
