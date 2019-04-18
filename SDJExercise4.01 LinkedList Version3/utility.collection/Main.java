public class Main {

	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<String>();

		list.add("picus");
		list.set(0, "lel");
		/*list.add("kokot");
		list.add(1, "FUCK");
		System.out.println(list.toString());
		list.remove("kokot");
		list.remove("picus");*/
		System.out.println(list.indexOf("lel"));
		
		
		
		System.out.println(list.toString());
//		System.out.println(list.size());
//		System.out.println(list.get(2));
//		System.out.println(list.contains("lol"));
	}

}