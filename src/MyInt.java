
public class MyInt {
	
	private byte IS_MORE = 1;
	private byte IS_LESS = -1;
	private byte IS_EQUAL = 0;
	
	
	private String val;
	private boolean negative;
	public MyInt(int val) {
		String strval = String.valueOf(val);
		
		this.negative = (strval.charAt(0) == '-');
		if (this.negative) {
			strval = strval.substring(1);
		} 		
		
		this.val = strval;
	}
	
	public boolean is_negative() {
		return this.negative;
	}	
	
	public MyInt(String val) {
		this.negative = (val.charAt(0) == '-');
		if (this.negative) {
			val = val.substring(1);
		}
		

		this.val = val;
	}
	
	public String toString() {

		return ((this.is_negative() ? "-" : "") + this.val);
	}
	
	public MyInt abs() {
		return new MyInt(this.val);
	}
	
	public MyInt max(MyInt val) {
		
		if (this.is_negative() && !val.is_negative()) return new MyInt(val.toString());
		if (!this.is_negative() && val.is_negative()) return new MyInt(this.toString());
		
		
		if (this.is_negative() && val.is_negative()) {
			MyInt a = this.abs();
			MyInt b = val.abs();
			return new MyInt(a.min(b).toString());
		}
		
		
		int ourLength = this.val.length();
		int valLength = val.toString().length();
		
		if (ourLength > valLength) {
			return new MyInt(this.toString());
		} else {
			if (ourLength < valLength) {
				return new MyInt(val.toString());
			} else {
				for (int i = 0; i < ourLength; i++) {
					int a = Character.getNumericValue(this.val.charAt(i));
					int b = Character.getNumericValue(val.toString().charAt(i));
					if (a > b) {
						return new MyInt(this.toString());
					} else {
						if (a < b) {
							return new MyInt(val.toString());	
						}
					}
				}
				return new MyInt(0);
			}
		}
	}
	
	public MyInt min(MyInt val) {
		
		if (this.is_negative() && !val.is_negative()) return new MyInt(this.toString());
		if (!this.is_negative() && val.is_negative()) return new MyInt(val.toString());
		
		
		if (this.is_negative() && val.is_negative()) {
			MyInt a = this.abs();
			MyInt b = val.abs();
			return new MyInt(a.max(b).toString());
		}
		
		
		int ourLength = this.val.length();
		int valLength = val.toString().length();
		
		if (ourLength < valLength) {
			return new MyInt(this.toString());
		} else {
			if (ourLength > valLength) {
				return new MyInt(val.toString());
			} else {
				for (int i = 0; i < ourLength; i++) {
					int a = Character.getNumericValue(this.val.charAt(i));
					int b = Character.getNumericValue(val.toString().charAt(i));
					if (a < b) {
						return new MyInt(this.toString());
					} else {
						if (a > b) {
							return new MyInt(val.toString());	
						}
					}
				}
				return new MyInt(0);
			}
		}
	}
	
	
	public byte compareTo(MyInt val) {

		if (this.is_negative() && !val.is_negative()) return IS_LESS;
		if (!this.is_negative() && val.is_negative()) return IS_MORE;
		
		
			MyInt a = this.abs();
			MyInt b = val.abs();

			if (a.toString().equals(b.toString())) {
				return IS_EQUAL;
			}
			
			MyInt min = a.min(b);
			
			if (a.toString().equals(min.toString())) {
				return IS_LESS;
			}
			
			if (b.toString().equals(min.toString())) {
				return IS_MORE;
			}
		

		
		MyInt max = this.max(val);
		
		
		
		if (this.toString().equals(val.toString())) {
			return IS_EQUAL;
		}
		
		if (this.toString().equals(max.toString())) {
			return IS_MORE;
		}
		
		if (this.toString().equals(max.toString())) {
			return IS_LESS;
		}

		return IS_EQUAL;
	}
	
	
	public int length() {
		return this.val.length();
	}
	
	
	public MyInt reverse_abs() {
		StringBuffer buffer = new StringBuffer(this.val);

	    return new MyInt(buffer.reverse().toString());
	}
	
	public MyInt multiply(MyInt val) {
		String result = "";
		
		
		int total_length = this.length() + val.length() - 1;
		
		MyInt a = this.reverse_abs();
		MyInt b = val.reverse_abs();
		
		int[] res_chars = new int[total_length];
		
		for (int k = 0; k < total_length; k++) {
			int sum = 0;
			for (int i = 0; i < a.length(); i++) {
				int j = k - i;
				if (j >= 0 && j < b.length()) {
					int a_val = Integer.parseInt(a.toString().charAt(i) + "");
					int b_val = Integer.parseInt(b.toString().charAt(j) + "");
	    			sum += a_val * b_val;
				}
				
				res_chars[k] = sum;
			}
		}
		
		for (int i = 0; i < total_length - 1; i++) {
			int p =	res_chars[i] % 10;
			int q = res_chars[i] / 10;
			res_chars[i] = p;
	  		res_chars[i + 1] += q;	
		}
		
		for(int i = 0; i < res_chars.length / 2; i++)
		{
		    int temp = res_chars[i];
		    res_chars[i] = res_chars[res_chars.length - i - 1];
		    res_chars[res_chars.length - i - 1] = temp;
		}		
		
		

		for (int i = 0; i < res_chars.length; i++) {
			result += String.valueOf((int)res_chars[i]);
		}
		
		if ((this.is_negative() && !val.is_negative()) || (!this.is_negative() && val.is_negative())) {
			result = "-" + result;
		}
		
		return new MyInt(result);
	}
	
	public long longValue() {
		long result = Long.valueOf(this.toString());
		return result;
	}
	
	public MyInt gcd(MyInt val) {		
		long a = this.longValue();
		long b = val.longValue();
		
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return new MyInt(String.valueOf(a));
        
    }

	public MyInt subtract(MyInt val) {
		
		
		if (this.is_negative() && !val.is_negative()) {
			return new MyInt("-" + this.abs().add(val).toString());
		}
		
		if (!this.is_negative() && val.is_negative()) {
			return new MyInt(this.add(val.abs()).toString());
		}
		
		if (this.is_negative() && val.is_negative()) {
			MyInt a = this.abs();
			MyInt b = val.abs();
			
			MyInt max = a.max(b);
			MyInt min = a.min(b);
			MyInt sub =  max.subtract(min);
			
			if (max.toString().equals(a.toString())) {
				return new MyInt("-" + sub.toString());
			} else {
				return new MyInt(sub.toString());
			}
		}
		
		
		MyInt max = this.max(val);
		MyInt min = this.min(val);
		
		String newVal = "";
		boolean vume = false;
		
		StringBuffer buffer = new StringBuffer(max.toString());
	    max = new MyInt(buffer.reverse().toString());
	    
	    buffer = new StringBuffer(min.toString());
	    
	    min = new MyInt(buffer.reverse().toString());
	    
	    
		
		
		for (int i = 0; i < max.toString().length(); i++) {
			int high = Character.getNumericValue(max.toString().charAt(i));
			int low = 0;
			int total;
			
			if (i < min.toString().length()) {
				low = Character.getNumericValue(min.toString().charAt(i));
			}
			
			if (vume) {
				high--;
				vume = false;
			}
			

			if (high >= low) {
				total = high - low;
			} else {
				total = (10 + high) - low;
				vume = true;
			}

			newVal = String.valueOf(total) + newVal;
			
		}

		if (this.compareTo(val) == IS_LESS) {
			newVal = "-" + newVal;
		}
		
		return new MyInt(newVal);
	}
	
	public MyInt add(MyInt val) {
		MyInt min;
		MyInt max;
		
		
		if (this.is_negative() && !val.is_negative()) {			
			if (this.abs().compareTo(val) == IS_MORE) {
				return new MyInt("-" + this.abs().subtract(val));
			}
			if (this.abs().compareTo(val) == IS_LESS) {
				return new MyInt("-" + val.subtract(this.abs()));
			}
			return new MyInt("0");
		}
		if (!this.is_negative() && val.is_negative()) {			
			if (val.abs().compareTo(this) == IS_MORE) {
				return new MyInt("-" + val.abs().subtract(this));
			}
			if (val.abs().compareTo(this) == IS_LESS) {
				return new MyInt("-" + this.subtract(val.abs()));
			}
			return new MyInt("0");
		}		
		
		
		
		if (this.is_negative() && val.is_negative()) {
			this.val = this.abs().toString();
			val = val.abs();
		}
		
		min = this.min(val);
		max = this.max(val);
		
		
		StringBuffer buffer = new StringBuffer(max.toString());
	    max = new MyInt(buffer.reverse().toString());
	    
	    buffer = new StringBuffer(min.toString());
	    
	    min = new MyInt(buffer.reverse().toString());		
		
		
		String newVal = "";
		boolean vume = false;
		for (int i = 0; i < max.toString().length(); i++) {
			int high = Character.getNumericValue(max.toString().charAt(i));
			int low = 0;
			
			if (i < min.toString().length()) {
				low = Character.getNumericValue(min.toString().charAt(i));
			}
			
			
			int total = high + low;
			
			if (vume) {
				vume = false;
				total++;
			}
			
			if (total > 9) {
				newVal = String.valueOf(total - 10) + newVal;
				vume = true;
			} else {
				newVal = String.valueOf(total) + newVal;
			}
			
		}
		
		if (vume) {
			vume = false;
			newVal = "1" + newVal;
		}
		
		if (this.is_negative() && val.is_negative()) {
			newVal = "-" + newVal;
		}
		
		return new MyInt(newVal);
	}
	
}
