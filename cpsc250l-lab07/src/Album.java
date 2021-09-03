public class Album implements Comparable<Album> {
    private String author;
    private String name;
    private int length;
    /**
     * Creates an Album object consisting of a band name, an album name, and a
     * length.
     *
     * @param _author
     *            The band name
     * @param _name
     *            The album name
     * @param _length
     *            The length of the album (in seconds)
     */
    public Album(String _author, String _name, int _length) {
        author = _author;
        name = _name;
        length = _length;
    }

    /**
     * @param other
     *            The Album which we compare to this one.
     */
    @Override
    public int compareTo(Album other) {
        if(!(author.equals(other.getAuthor()))) {
            return author.compareTo(other.getAuthor());
        }
        else if (!(name.equals(other.getName()))) {
            return name.compareTo(other.getName());
        }
        else{
        return length - other.getLength();
        }
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
