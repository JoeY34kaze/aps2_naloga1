public class Naloga1 {
	public static String nacin; //tr || co
	public static String algo; //ss,ms,hs,...
	public static String order;//asc, desc
	public static int table_length;


	public static void main(String[] args) {
		set_arg(args, args.length);
		
		
		
		
		run_algo(read_intArray_from_stdin(),nacin, algo, order, table_length);
	}
	
	private static int[] read_intArray_from_stdin() {//za napisat
		// TODO Auto-generated method stub
		int[] r= {8, 5, 6, 1, 7, 2};
		return r;
	}

	private static void set_arg(String[] a, int b){
		if(b>3){table_length=Integer.parseInt(a[3]);}
		if(b>2){order=a[2];}
		if(b>1){algo=a[1];}
		if(b>0){nacin=a[0];}
	}

	public static void run_algo(int[] in, String nac, String al, String ord,
			int len) {
		if (al.equals("bs") && ord.equals("up")) {
			int[] urejen = bs_asc(in, len);
			if (nacin.equals("count")) {// se druga dva nacina za count
				bs_asc(urejen, len);
				bs_desc(urejen, len);
			}
		} else if (al.equals("bs") && ord.equals("down")) {
			int[] urejen = bs_desc(in, len);
			if (nacin.equals("count")) {// se druga dva nacina za count
				bs_desc(urejen, len);
				bs_asc(urejen, len);
			}
		} else {
		}
	}
	
	public static void izpisi_sled(int[] in, int dolzina_urejenega_dela){
		String iz="";
		for(int i=0;i<in.length;i++){
			if(i==dolzina_urejenega_dela){iz=iz+"| ";}
			iz=iz+in[i]+" ";
		}
		System.out.println(iz);
	}

	private static int[] bs_asc(int[] in, int len) {//vrne st primerjav in premikov v tabeli    bs asc naj bi bil zakljucen
		int prim=0;
		int prem=0;
		int i;
		int dolzina_urejenega_dela=0;
		boolean je_zamenjava_bla = true; // za prvi obhod
		int temp;
		while (je_zamenjava_bla) {
			
			if(nacin.equals("trace")){izpisi_sled(in, dolzina_urejenega_dela);}
			
			je_zamenjava_bla = false;
			//System.out.println(in.length);
			for (i = (in.length-1); i > dolzina_urejenega_dela; i--) {//bolši pogoj kot da je veèji od 0 saj ne primerja naprej
				prim++;
				if (in[i] < in[i - 1])
				{
					temp = in[i];
					in[i] = in[i - 1];
					in[i - 1] = temp;
					je_zamenjava_bla = true;
					prem+=3;
					
				}
			}
			dolzina_urejenega_dela++;
		}
		if(nacin.equals("count")){System.out.println(prim+" "+prem);} //dela
		return in;

		
		
		
	}
	
	private static int[] bs_desc(int[] in,int len) {//vrne st primerjav in premikov v tabeli
		int prim=0;
		int prem=0;
		int i;
		int dolzina_urejenega_dela=0;
		boolean je_zamenjava_bla = true; // za prvi obhod
		int temp;
		while (je_zamenjava_bla) {
			
			if(nacin.equals("trace")){izpisi_sled(in, dolzina_urejenega_dela);}
			
			je_zamenjava_bla = false;
			//System.out.println(in.length);
			for (i = (in.length-1); i > dolzina_urejenega_dela; i--) {//bolši pogoj kot da je veèji od 0 saj ne primerja naprej
				prim++;
				if (in[i] > in[i - 1])
				{
					temp = in[i];
					in[i] = in[i - 1];
					in[i - 1] = temp;
					je_zamenjava_bla = true;
					prem+=3;
					
				}
			}
			dolzina_urejenega_dela++;
		}
		if(nacin.equals("count")){System.out.println(prim+" "+prem);} //dela
		return in;
		
	}
}

