class myArrayList{
	 private  int[] array;
	 private int size;
	 public myArrayList()
	 {
		 array=new int[2];
		 size=0;
	 }
	 public void ensureCapacity() {
			if (size >=array.length) {
			
			
			
			int newCapacity = array.length * 2;
			int[] newArray = new int[newCapacity];
			for (int i = 0; i < size; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
			}
			else
			{
				return;
			}
		}
	 public void pushBack(int e)
	 {
		 ensureCapacity();
		 array[size++]=e;
	 }
	 public void pushFront(int e)
	 {
		 ensureCapacity();
		 for(int i=size;i>=1;i--)
		 {
			 array[i]=array[i-1];
		 }
		 array[0]=e;
		 size++;
	 }
	 public void insert(int index,int e)
	 {
		 ensureCapacity();
		 for(int i=size;i>=(index+1);i--)
		 {
			 array[i]=array[i-1];
		 }
		 array[index]=e;
		 size++;
	 }
	 public void  popBack()
	 {
		 if (size <= 0) {
				System.err.println("˳���Ϊ��");
		 }
		 array[size-1]=0;
		 size=size-1;
	 }
	 public void popFront()
	 {
		 if (size <= 0) {
				System.err.println("˳���Ϊ��");
		 }
		 for(int i=0;i<=size-2;i++)
		 {
			 array[i]=array[i+1];
		 }
		 array[size-1]=0;
		 size=size-1;
	 }
	 public void delete(int index)
	 {
		 if (size <= 0) {
				System.err.println("˳���Ϊ��");
		 }
		 for(int i=index;i<=size-2;i++)
		 {
			 array[i]=array[i+1];
		 }
		 array[size-1]=0;
		 size=size-1;
	 }
	 public void to ()
	 {
		 for(int i=0;i<array.length;i++)
		 {
			 System.out.print(array[i]);
		 }
	 }
	// ���� element ��˳����е��±꣬������ֶ�Σ����ص�һ�γ��ֵ��±�
		public int indexOf(int element) {
			for (int i = 0; i < size; i++) {
				if (array[i] == element) {
					return i;
				}
			}
			
			return -1;
		}
		
		public int get(int index) {
			if (index < 0 || index >= size) {
				System.err.println("�±����");
				return -1;
			}
			return array[index];
		}
		
		public void set(int index, int element) {
			if (index < 0 || index >= size) {
				System.err.println("�±����");
				return;
			}
			array[index] = element;
		}
		
		// ɾ����ĳһ��Ԫ�أ�������ֶ�Σ�ɾ����һ�γ��ֵ�
		public void remove(int element) {
			int index = indexOf(element);
			if (index != -1) {
				delete(index);
			}
		}
		
		public int size() {
			return size;
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		public void removeAll(int element) {
			/* ʱ��:O(n^2)	ʱ�䣺O(1)
			int index;
			while ((index = indexOf(element)) != -1) {
				earse(index);
			}
			*/
			
			/* ʱ��: O(n)	�ռ�: O(n)
			int[] newArray = new int[array.length];
			int j = 0;
			for (int i = 0; i < size; i++) {
				if (array[i] != element) {
					newArray[j++] = array[i];
				}
			}
			array = newArray;
			size = j;
			*/
			
			// ʱ�䣺O(n)	�ռ䣺O(1)
			int j = 0;
			for (int i = 0; i < size; i++) {
				if (array[i] != element) {
					array[j++] = array[i];
				}
			}
			size = j;
			
		}
	 public static void main(String[]  args)
	 {
		 myArrayList a=new myArrayList();
		 a.pushBack(1); 
		 a.pushBack(2);
		 a.pushBack(3);//  1  2  3
		 a.pushFront(2);// 2  1  2  3
		 a.insert(1, 6);// 2  6  1  2  3
		 a.to();
		 System.out.println();
		 a.popBack();//    2  6  1  2 
		 a.popFront();//   6  1  2
		 a.delete(1);//    6  2
		 a.to();
		
		 
	 }
}



