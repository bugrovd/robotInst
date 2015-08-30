package client.setting;

/**
 * Created by home on 29.08.2015.
 */
public class Account {
    private String accessToken;
    private String userId;
    private String userName;
    private String fullName;

    public Account (String accessToken, String userId, String userName, String fullName) {
        this.accessToken = accessToken;
        this.userId = userId;
        this.userName = userName;
        this.fullName = fullName;
    }

    public String getAccessToken () {
        return accessToken;
    }

    public String getUserId () {
        return userId;
    }

    public String getUserName () {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }
}
