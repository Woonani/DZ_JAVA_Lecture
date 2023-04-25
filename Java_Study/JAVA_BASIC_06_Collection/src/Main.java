import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// 은행 생성 & 계좌 등록
		Bank bank = new Bank();
		bank.addAccount("10071", "백");
		bank.addAccount("890113", "택");
		bank.addAccount("0113", "택");
		bank.addAccount("987654321", "두팔");
		// 전체 계좌목록 조회
		bank.getAccounts();
		
		//해당 계좌번호의 계좌정보		
		Account account = bank.getAccount("890113");

		//입금
		account.deposit(20000);
//		bank.getAccount("890113");
//		account.deposit(20000);
		bank.getAccount("890113").deposit(20000);
		
		//해당 소유자명의 계좌 목록
		bank.findAccounts("택");
//		
		bank.getAccount("89011");
		bank.getAccount("890113");
//		
//		//인출
		account.withdraw(5500);
		bank.getAccount("890113");
//		System.out.println("하하"+account);
//	
		// 거래내역
		bank.getAccount("890113").getTransactions();		
	}

}

class Bank {
//	private ArrayList<Account> accounts = new ArrayList(); // 계좌(0개이상)
	private List<Account> accounts; // 계좌(0개이상)
	private int totalAccounts; // 총계좌수
	
	Bank(){
		this.accounts = new ArrayList<Account>(); // composition관계는 멤버필드에 선언, 생성은 생성자함수안에서!
	}
	
	public int getTotalAccounts() {
		
		return totalAccounts;
	}
	public void setTotalAccounts(int totalAccounts) {
		this.totalAccounts = totalAccounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	// 계좌를 생성한다
	public void addAccount(String accountNo, String name) {
		accounts.add( new Account(accountNo, name));
	}
	
	//계좌를 찾는다.(계좌번호로)
    public Account getAccount(String accountNo) {
    	System.out.println(" = 해당 계좌번호의 계좌정보 =");
        for (Account account : accounts) {
            if (account.getAccountNo().equals(accountNo)) {
            	System.out.println(account);
            	System.out.println();
                return account;
            }
        }
        System.out.println();
        return null;
    }
	//계좌를 찾는다. (소유자명으로)
	public ArrayList<Account> findAccounts(String name) {
		ArrayList<Account> foundAccounts = new ArrayList();
		System.out.println(" = 해당 소유자명의 계좌 목록 =");
		for(int i=0; i< accounts.size(); i++) {
			if(accounts.get(i).getName().equals(name)) {
				foundAccounts.add(accounts.get(i));
				System.out.println(accounts.get(i));
			}
		}
		System.out.println();
		return foundAccounts;
	}
	//계좌 목록을 본다.
	public List<Account> getAccounts() {
		System.out.println(" =전체 계좌 목록=");
		for(Account account: this.accounts) {
			System.out.println(account);
		}
		System.out.println();
		return this.accounts;
	}
	
	//총계좌수를 반환한다.
	public int getTotalAccount() {
		int totalAccount = accounts.size();
		return totalAccount;
	}
	
	
	
	
}

class Account {
    private String accountNo;
    private String name;
    private long balance;
    private ArrayList<Transaction> transactions;

    public Account(String accountNo, String name, long balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }
    
    public Account(String accountNo, String name) {
    	this( accountNo,  name, 0);
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public ArrayList<Transaction> getTransactions() {
    	System.out.println(" =거래내역=");
    	for(Transaction transaction : transactions) {
    		System.out.println(transaction);    		
    	}
        return transactions;
    }

    public void deposit(long amount) {
        this.balance += amount;
        System.out.println(amount+"원 입금하셨습니다.");
        System.out.println("현재잔액은 "+this.balance+"원 입니다");
        System.out.println();
        Transaction transaction = new Transaction(LocalDate.now().toString(), LocalTime.now().toString(), "Deposit", amount, balance);
        addTransaction(transaction);
    }

    public void withdraw(long amount) {
        this.balance -= amount;
        System.out.println(amount+"원 인출하셨습니다.");
        System.out.println("현재잔액은 "+this.balance+"원 입니다");
        System.out.println();
        Transaction transaction = new Transaction(LocalDate.now().toString(), LocalTime.now().toString(), "Withdrawal", amount, balance);
        addTransaction(transaction);
    }

    private void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

	@Override
	public String toString() {
		return " [계좌번호 :" + accountNo + ", 소유자 명 :" + name + ", 잔액 :" + balance + "]";
	}

    
}

class Transaction {
	   private String transactionDate;
	   private String transactionTime;
	   private String kind;
	   private long amount;
	   private long balance;

	   public Transaction(String transactionDate, String transactionTime, String kind, long amount, long balance) {
	      this.transactionDate = transactionDate;
	      this.transactionTime = transactionTime;
	      this.kind = kind;
	      this.amount = amount;
	      this.balance = balance;
	   }

	   public String getTransactionDate() {
	      return transactionDate;
	   }

	   public void setTransactionDate(String transactionDate) {
	      this.transactionDate = transactionDate;
	   }

	   public String getTransactionTime() {
	      return transactionTime;
	   }

	   public void setTransactionTime(String transactionTime) {
	      this.transactionTime = transactionTime;
	   }

	   public String getKind() {
	      return kind;
	   }

	   public void setKind(String kind) {
	      this.kind = kind;
	   }

	   public long getAmount() {
	      return amount;
	   }

	   public void setAmount(long amount) {
	      this.amount = amount;
	   }

	   public long getBalance() {
	      return balance;
	   }

	   public void setBalance(long balance) {
	      this.balance = balance;
	   }

	@Override
	public String toString() {
		return "거래금액: "+amount+"  잔액: "+ balance+ "/" + transactionDate.substring(0,4)+ "년" + transactionDate.substring(5,7)+ "월" + transactionDate.substring(8,10)+ "일" +  
	transactionTime.substring(0, 2)+"시"+transactionTime.substring(3, 5)+"분"+transactionTime.substring(6, 8)+"초";//02/35/68
	}
	   
	}