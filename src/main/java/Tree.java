import java.util.Arrays;

/**
 * 
 */

/**
 * @author Administrator
 *
 */
public class Tree <E>{
	E root;
	Tree<E> left;
	Tree<E> right;	
	/**
	 * 
	 */
	public Tree(E root, Tree<E> left, Tree<E> right) {
		this.root=root;
		this.left=left;
		this.right=right;
		
	}

	public Tree(E root){
		this.root=root;
		this.left=null;
		this.right=null;
		
	}
	
	public  Tree (E[]args){
		int len=args.length;

		switch ( len){
		case 1 : this.root=args[0];this.left=null;this.right=null;break;
		case 2 : this.root=args[0];this.left=new Tree<E>(args[1]);this.right=null;break;
		case 3 : this.root=args[0];this.left=new Tree<E>(args[1]);this.right=new Tree<E>(args[2]);break;
		default: this.root=args[0];this.left=new Tree<E>(Arrays.copyOfRange(args, 1, (len+3)/2));this.right=new Tree<E>(Arrays.copyOfRange(args, (len+3)/2, len));break;
		}


	}
	
	@Override
	public String toString(){
		if(left!=null){
			if(right!=null){
				return root.toString()+","+left.toString()+right.toString();
			}
			else{
				return root.toString()+","+left.toString();
			}
		}
		else{
			if(right!=null){
				return root.toString()+","+right.toString();
			}
			else{
				return  root.toString()+" ";
			}
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree<Integer> tree1 =new Tree<>(3);
		PatternTest.p(tree1.toString());
		Integer[] arrays={1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		Tree<Integer> tree2 = new Tree<Integer>(arrays);
		PatternTest.p(tree2.toString());
	}

}
