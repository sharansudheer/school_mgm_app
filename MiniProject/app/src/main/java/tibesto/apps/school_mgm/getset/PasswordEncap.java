package tibesto.apps.school_mgm.getset;

public class PasswordEncap {

        private String userName;
        private String password;

        public PasswordEncap(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


}
