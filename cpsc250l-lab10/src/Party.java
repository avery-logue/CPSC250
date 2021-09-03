import java.util.ArrayList;

public class Party {

    private ArrayList<Person> invited = new ArrayList<Person>();
    private ArrayList<Person> rsvpYes = new ArrayList<Person>();
    private ArrayList<Person> rsvpNo = new ArrayList<Person>();

    public Party() {
        ArrayList<Person> invited = new ArrayList<Person>();
        ArrayList<Person> rsvpYes = new ArrayList<Person>();
        ArrayList<Person> rsvpNo = new ArrayList<Person>();
    }
    public void addInvited (Person p) {
        Person pnew = p.copy();
        if (invited.contains(p)) {
            return;
        }
        else {
            invited.add(pnew);
        }
    }
    public ArrayList<Person> getInvited(){
        ArrayList<Person> copy = new ArrayList<Person>();
        for (int i = 0; i < invited.size(); i++) {
            Person p = invited.get(i).copy();
            copy.add(p);
        }
        return copy;
    }
    public void addRSVP(Person p, boolean accepted) {
        Person pnew = p.copy();
        if (invited.contains(p)) {
            if (accepted) {
                rsvpYes.add(pnew);
            }
            else {
                rsvpNo.add(pnew);
            }
        }
    }
    public ArrayList<Person> getRSVP(boolean accepted) { //had some help from William Dzubak. Gave me the idea to copy the person and then add instead of just using .copy
        ArrayList<Person> copy = new ArrayList<Person>();
        if (accepted) {

            for (int i = 0; i < rsvpYes.size(); i++) {
                Person p = rsvpYes.get(i).copy();
                copy.add(p);
            }
        }
        else {
            //ArrayList<Person> copy = new ArrayList<Person>();
            for (int i = 0; i < rsvpNo.size(); i++) {
                Person p = rsvpNo.get(i).copy();
                copy.add(p);
            }

        }
        return copy;
    }
    public boolean equals(Object o) {
        if (!(o instanceof Party)) {
            return false;
        }
        Party other = (Party) o;
//        ArrayList<Person> otherInvited = other.getInvited();
//        for (int i = 0; i < invited.size(); i++) {
//            Person p = invited.get(i).copy();
//            Person op = otherInvited.get(i).copy();
//            String temp = p.getName();
//            String oTemp = op.getName();
//
//            if (!(temp.equals(oTemp))) {
//                return false;
//            }
//            else {
//                count++;
//            }
//        }
        if (other.invited.containsAll(invited) && other.rsvpYes.containsAll(rsvpYes) && other.rsvpNo.containsAll(rsvpNo)){
            return true;
        }

        return false;

    }
}
