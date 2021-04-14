package ProgramacionIII.tp1;

public class DoubleNode {
    private Integer info;
	private DoubleNode next;
    private DoubleNode previous;

	public DoubleNode() {
		this.info = null;
		this.next = null;
	}
	
	public DoubleNode(Integer o, DoubleNode n, DoubleNode i) {
		this.setInfo(o);
		this.setNext(n);
        this.setPrevious(i);
	}
	
	public void setPrevious(DoubleNode previous) {
        this.previous = previous;
    }

    public DoubleNode getPrevious() {
        return this.previous;
    }
    public DoubleNode getNext() {
		return next;
	}

	public void setNext(DoubleNode next) {
		this.next = next;
	}

	public Integer getInfo() {
		return info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}
}
