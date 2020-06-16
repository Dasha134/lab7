package lab7.utils;
import java.util.Random;
// класс для генерации случайного эл. адреса
public class EmailGenerator
{
    private static final String ch = "qwertyuiopasdfghjklzxcvbnm1234567890";
    private static final int email_l = 13;
    private static final String email_d = "@test.com";
    public static String generateEmail()
    {
        StringBuilder em = new StringBuilder();
        Random rand = new Random();
        while (em.length() < email_l)
        {
            int index = (int) (rand.nextFloat() * EmailGenerator.ch.length());
            em.append(EmailGenerator.ch.charAt(index));
        }
        return em.toString() + EmailGenerator.email_d;
    }
}
