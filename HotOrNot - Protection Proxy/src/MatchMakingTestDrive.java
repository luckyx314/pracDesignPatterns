import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class MatchMakingTestDrive {
    static ArrayList<Person> pips = new ArrayList<>();

    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();

        Person lucky = pips.get(0);
        Person ownerProxy = test.getOwnerProxy(lucky);

        System.out.println("Owner Name is: " + lucky.getName());
        ownerProxy.setInterest("Soccer");
        System.out.println("New interest set using owner proxy");
        System.out.println(ownerProxy.getName() + " likes " + ownerProxy.getInterest());
        System.out.println("\n--SETTING OUR OWN \"HOTNESS\" RATING--");
        try {
            ownerProxy.setHotOrNotRating(100);
        } catch (Exception e) {
            System.out.println("Account owner cannot set his/her own rating!");
            System.out.println("You cheeky son of a bitch!");
        }

        System.out.println();
        // let's make lucky a non-owner
        System.out.println("--MADE LUCKY A NON-OWNER--");
        Person nonOwnerProxy = test.getNonOwnerProxy(lucky);
        try {
            nonOwnerProxy.setInterest("Basketball");
        } catch (Exception e) {
            System.out.println("A non owner cannot set other people's interests.");
            System.out.println("Ngi, ayaw pag buot!");
        }
    }

    public MatchMakingTestDrive() {
        initPeople();
    }

    Person getOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person)
        );
    }

    Person getNonOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person)
        );
    }

    void  initPeople() {
        Person p1 = new PersonImpl();
        p1.setName("Lucky");
        p1.setGender("Male");
        p1.setInterest("Music");
        p1.setHotOrNotRating(0);
        pips.add(p1);

        Person p2 = new PersonImpl();
        p2.setName("Jane");
        p2.setGender("Female");
        p2.setInterest("Music");
        p2.setHotOrNotRating(0);
        pips.add(p2);

        Person p3 = new PersonImpl();
        p3.setName("John");
        p3.setGender("Male");
        p3.setInterest("Basketball");
        p3.setHotOrNotRating(0);
        pips.add(p3);
    }
}