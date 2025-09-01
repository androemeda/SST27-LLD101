import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();
        UserProfile p = svc.createMinimal("u1", "a@b.com");
        System.out.println("Created immutable profile: " + p.getEmail());
        
        // Demonstrate builder usage with optional fields
        UserProfile fullProfile = UserProfile.builder("u2", "user@example.com")
            .displayName("John Doe")
            .phone("123-456-7890")
            .marketingOptIn(true)
            .build();
            
        System.out.println("Built profile with optional fields:");
        System.out.println("  ID: " + fullProfile.getId());
        System.out.println("  Email: " + fullProfile.getEmail());
        System.out.println("  Display Name: " + fullProfile.getDisplayName());
        System.out.println("  Phone: " + fullProfile.getPhone());
        System.out.println("  Marketing Opt-in: " + fullProfile.isMarketingOptIn());
    }
}
