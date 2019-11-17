public class Branch
{
   String BranchName;
   String IFSCcode;
   String BranchAddress;
   public Branch(String Branchname , String IFSCcode, String BranchAddress)
   {
      this.BranchName=Branchname;
      this.IFSCcode = IFSCcode;
      this.BranchAddress = BranchAddress;
   }
   public void setBranchName(String BranchName)
   {
      this.BranchName = BranchName;
   }
   public String getBranchName()
   {
      return this.BranchName;
   }
   public  void setIFSCcode(String IFSCcode)
   {
      this.IFSCcode = IFSCcode;;
   }
   public String getIFSCcode()
   {
      return this.IFSCcode;
   }
   public void setBranchAddress(String BranchAddress)
   {
      this.BranchAddress = BranchAddress;
   }
   public String getBranchAddress()
   {
      return this.BranchAddress;
   }
   public void ShowDetails()
   {
      System.out.println("******branch details are********");
      System.out.println("name of the branch is "+this.getBranchName());
      System.out.println("IFSC code of the branch!!!"+this.getIFSCcode());
      System.out.println("Address of the Branch"+this.getBranchAddress());
      System.out.println("**********closed***********");
   }

   
}