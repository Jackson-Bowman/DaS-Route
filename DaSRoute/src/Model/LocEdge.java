package Model;

/**
 * a connection between two locations in Dark Souls
 */
public class LocEdge {
    // the source node of the edge
    private Location v1;
    // the target node of the edge
    private Location v2;

    public LocEdge(Location v1, Location v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
    /**
     * get the source vertex of the edge
     * (in an undirected graph this distinction is arbitrary)
     * @return the source vertex
     */
    public Location getSource() {
        return this.v1;
    }

    /**
     * get the target vertex of the edge
     * (in an undirected graph this distinction is arbitrary)
     * @return the target vertex
     */
    public Location getTarget() {
        return this.v2;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof LocEdge) {
            LocEdge l = (LocEdge)other;
            return this.v1.equals(l.getSource()) && this.v2.equals(l.getTarget());
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.v1.hashCode() + this.v2.hashCode();
    }

}
