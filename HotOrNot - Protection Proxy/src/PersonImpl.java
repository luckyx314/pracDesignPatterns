public class PersonImpl implements Person{
    String name;
    String gender;
    String interests;

    int hotOrNotRating;
    int ratingCount = 0;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterest() {
        return interests;
    }

    @Override
    public int getHotOrNotRating() {
        return hotOrNotRating;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterest(String interest) {
        this.interests = interest;
    }

    @Override
    public void setHotOrNotRating(int rating) {
        this.hotOrNotRating = rating;
        ratingCount++;
    }
}
