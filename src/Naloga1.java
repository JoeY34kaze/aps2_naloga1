import java.util.Arrays;
import java.util.Scanner;

public class Naloga1 {
	public static String nacin; //tr || co
	public static String algo; //ss,ms,hs,...
	public static String order;//asc, desc
	public static int table_length=-1;
	
	public static int[] za_qs;


	
	
 	private static int[] read_intArray_from_stdin() {//za napisat
		
		if(table_length==-1){
			int[] rez= new int[1];
			Scanner s=new Scanner(System.in);
			int i=0;
			while (s.hasNextInt()) {
				rez[i] = s.nextInt();
				if(!s.hasNextInt()) break;
				else{
					rez = Arrays.copyOf(rez, rez.length+1);
					i++;
				}
			}
			return rez;
		}else{//ce je dolzina podana
			int[] rez= new int[table_length];
			Scanner s=new Scanner(System.in);
			int i=0;
			while ((s.hasNextInt())&&(i<table_length)) {
				rez[i] = s.nextInt();
				if(!s.hasNextInt()){ break;}
					i++;
				
			}
			return rez;
		}
		
		
	} 

	private static int[] bs_asc(int[] in, int len) {//   bs asc naj bi bil zakljucen
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

	private static int[] bs_desc(int[] in,int len) {//

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

	private static int[] ss_asc(int[] in, int len) {//algo dela zakon
		int prim=0;
		int prem=0;
		int a=0;
		int b=in.length-1;
		int min=in[b];
		int i_min=b;
		while(a<b){
			if(nacin.equals("trace")){izpisi_sled(in, a);}
			for(int i=b;i>a;i--){
				//get min
				if(in[i-1]<min){
					min=in[i-1];
					i_min=i-1;
				}
				prim++;
			}
			//swap
			int temp=in[a];
			in[a]=in[i_min];
			in[i_min]=temp;
			min=in[b];
			i_min=b;
			a++;
			prem+=3;
		}
		if(nacin.equals("trace")){izpisi_sled(in, a);}
		if(nacin.equals("count")){System.out.println(prim+" "+prem);} //dela
		return in;
	}

	private static int[] ss_desc(int[] in, int len) {
		int prim=0;
		int prem=0;
		int a=0;
		int b=in.length-1;
		int max=in[b];
		int i_max=b;
		while(a<b){
			if(nacin.equals("trace")){izpisi_sled(in, a);}
			for(int i=b;i>a;i--){
				//get min
				if(in[i-1]>max){
					max=in[i-1];
					i_max=i-1;
				}
				prim++;
			}
			//swap
			int temp=in[a];
			in[a]=in[i_max];
			in[i_max]=temp;
			max=in[b];
			i_max=b;
			a++;
			prem+=3;
		}
		if(nacin.equals("trace")){izpisi_sled(in, a);}
		if(nacin.equals("count")){System.out.println(prim+" "+prem);} //dela
		return in;
		
	}
	
	
	private static int[] is_asc(int[] in, int len) {
		int a=1;
		int b=in.length-1;
		int prim=0;
		int prem=0;
		int t;
		int i=1;
		while(a<=b){
			t=a;
			if(nacin.equals("trace")){izpisi_sled(in, a);}
			while((t>0)){
				prim++;
				if((in[t]<in[t-1])){
					if(t==1){
						prim-=1; //because of some bullshit deduct
						prem+=3;
						int temp=in[t-1];
						in[t-1]=in[t];
						in[t]=temp;
						t--;
					}
					else{
						prem+=3;
						int temp=in[t-1];
						in[t-1]=in[t];
						in[t]=temp;
						t--;
					}
				}
				else{
					
					t--;
				}

			}
			a++;
		}
		if(nacin.equals("trace")){izpisi_sled(in, a);}
		if(nacin.equals("count")){System.out.println(prim+" "+prem);}
		return in;
	}


	private static int[] is_desc(int[] in, int len) {
		int a=1;
		int b=in.length-1;
		int prim=0;
		int prem=0;
		int t;
		int i=1;
		while(a<=b){
			t=a;
			if(nacin.equals("trace")){izpisi_sled(in, a);}
			while((t>0)){
				prim++;
				if((in[t]>in[t-1])){
					if(t==1){
						prim-=1; //because of some bullshit deduct
						prem+=3;
						int temp=in[t-1];
						in[t-1]=in[t];
						in[t]=temp;
						t--;
					}
					else{
						prem+=3;
						int temp=in[t-1];
						in[t-1]=in[t];
						in[t]=temp;
						t--;
					}
				}
				else{
					
					t--;
				}

			}
			a++;
		}
		if(nacin.equals("trace")){izpisi_sled(in, a);}
		if(nacin.equals("count")){System.out.println(prim+" "+prem);}
		return in;
	}

	public static void main(String[] args) {
		set_arg(args, args.length);
		
		
		
		//int[] a=read_intArray_from_stdin();
		
		//for(int n:a){System.out.println("- "+n);}
		
		
		//int[] a= {8,5,6,1,7,2};
		int[] a= {8, 5, 6, 1, 7, 2, 0, 9};
		run_algo(a,nacin, algo, order, table_length);
		//izpisi_sled_qs(za_qs, 0, 0);
	}

	public static void izpisi_sled(int[] in, int dolzina_urejenega_dela){
		String iz="";
		for(int i=0;i<in.length;i++){
			if(i==dolzina_urejenega_dela){iz=iz+"| ";}
			iz=iz+in[i]+" ";
		}
		if(dolzina_urejenega_dela == in.length){iz=iz+"| ";}
		System.out.println(iz);
	}
	
	public static void run_algo(int[] in, String nac, String al, String ord, int len) {
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
		}else if (al.equals("ss") && ord.equals("up")) {
			int[] urejen = ss_asc(in, len);
			if (nacin.equals("count")) {// se druga dva nacina za count
				ss_asc(urejen, len);
				ss_desc(urejen, len);
			}
		}
		else if (al.equals("ss") && ord.equals("down")) {
			int[] urejen = ss_desc(in, len);
			if (nacin.equals("count")) {// se druga dva nacina za count
				ss_desc(urejen, len);
				ss_asc(urejen, len);
			}
		}else if (al.equals("is") && ord.equals("up")) {
			int[] urejen = is_asc(in, len);
			if (nacin.equals("count")) {// se druga dva nacina za count
				is_asc(urejen, len);
				is_desc(urejen, len);
			}
		}else if (al.equals("is") && ord.equals("down")) {
			int[] urejen = is_desc(in, len);
			if (nacin.equals("count")) {// se druga dva nacina za count
				is_desc(urejen, len);
				is_asc(urejen, len);
			}
		}else if (al.equals("qs") && ord.equals("up")) {
			za_qs=in;
			System.out.println("sled: -");
			qs_asc();
			if (nacin.equals("count")) {// se druga dva nacina za count
				qs_asc();//urejen je itak
				qs_desc(); //isto bi mogl delat
			}
		}else if (al.equals("qs") && ord.equals("down")) {
			za_qs=in;
			qs_desc();
			if (nacin.equals("count")) {// se druga dva nacina za count
				qs_desc();
				qs_asc();
			}
		}
		
	}

	private static void qs_desc() {
		divide_desc(0, za_qs.length-1);	
	}

	public static void divide_desc(int levi, int desni){ //to je zdej samo za up
		int i = levi, j = desni;
        int pivot = za_qs[(i+j)/2];
	    while (i <= j) {
	      while (za_qs[i] > pivot) {
	        i++;
	      }
	      while (za_qs[j] < pivot) {
	        j--;
	      }
	      if (i <= j) {
	        exchange(i, j);
	        i++;
	        j--;
	      }
	    }
	    izpisi_sled_qs(levi,desni,j,i);
        if(levi < j) divide_desc(levi,j); // leva polovica od zaèetka tabele do elementa, pri katerem se tabela deli
        if(i < desni) divide_desc(i, desni); // desna polovica od elementa+1, kjer se je tabela delila do konca tabele
	}
	
	
	
	private static void exchange(int i, int j) {
	    int temp = za_qs[i];
	    za_qs[i] = za_qs[j];
	    za_qs[j] = temp;
	  }
	

	private static int qs_desc(int levi, int desni) {
		return (Integer) null;
	}


	private static int[] double_array(int[] a, int vel){
		if(vel<2){vel=2;}
		else {vel*=2;}
		int [] rez2= new int[vel];
		//prepisat array i guess
		   for(int j = 0; j < a.length; ++j) {
			      rez2[j] = a[j];
			    }
		   return rez2;//priredit rez<-rez2
	}

	/*private static int[] read_intArray_from_stdin() {//za napisat
		int vel=1;
		if(table_length!= -1){vel=table_length;}
		else{table_length=0;}
		int[] rez= new int[vel];
		Scanner s=new Scanner(System.in);
		int i=0;
		while (s.hasNextInt()) {
			//System.out.println("aaa");
			if(i>=rez.length){//ce je vecji je treba tabelo alocirat naprej
				if(vel<2){vel=2;}
				else {vel*=2;}
				rez=double_array(rez,vel);
			}
		        rez[i]=s.nextInt();
		        i++;
		        table_length++;//globaln stevec za stevilo elementov ce bo treba
		        System.out.println("i: "+i);
		     
		  }
		s.close();
		
		int[] r= {8, 5, 6, 1, 7, 2};
		for(int n:rez){System.out.printf("%d",n);}
		return r;
	} */
	
	private static void set_arg(String[] a, int b){
		if(b>3){table_length=Integer.parseInt(a[3]);}
		if(b>2){order=a[2];}
		if(b>1){algo=a[1];}
		if(b>0){nacin=a[0];}
	}

	public static void qs_asc() {
	    divide_asc(0,za_qs.length-1);
	  }

	public static void divide_asc(int levi, int desni){ //to je zdej samo za up
		int i = levi, j = desni;
	    int pivot = za_qs[(i+j)/2];
	    while (i <= j) {
	      while (za_qs[i] < pivot) {
	        i++;
	      }
	      while (za_qs[j] > pivot) {
	        j--;
	      }
	      if (i <= j) {
	        exchange(i, j);
	        i++;
	        j--;
	      }
	    }
	    izpisi_sled_qs(levi,desni,i,j);
	    if(levi < j) divide_asc(levi,j); // leva polovica od zaèetka tabele do elementa, pri katerem se tabela deli
	    if(i < desni) divide_asc(i, desni); // desna polovica od elementa+1, kjer se je tabela delila do konca tabele
	}

	public static void izpisi_sled_qs(int levi, int desni, int i, int j){
		j++;
		String iz="";
		for(int stev1=levi;stev1<=desni;stev1++){
			if(stev1==i){iz=iz+"| ";}
			if(stev1==j){iz=iz+"| ";}
			iz=iz+za_qs[stev1]+" ";
		}
		System.out.println(iz);
	}
}

