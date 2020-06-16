package lab7.Model;
import lombok.*;
@Data
// класс, содержащий все переменные, описывающие данные при регистрации
public class Acc
{
	private String name;			// имя
    private String surname;			// фамилия
    private String gender;			// пол
    private String email;			// эл. адрес
    private String password;		// пароль
    private String bd;				// день рождения
    private String bm;				// месяц рождения
    private String byr;				// год рождения
    private boolean newsletter;		// подписка на рассылку
    private boolean specialOffers;	// подписка на спец. предложения
    private String company;			// компания
    private String address1;		// адрес1
    private String address2;		// адрес2
    private String city;			// город
    private String state;			// штат
    private String postCode;		// почтовый код
    private String country;			// страна
    private String additionalInfo;	// доп. информация
    private String homePhone;		// домашний телефон
    private String mobilePhone;		// мобильный телефон
    private String addressAlias;
}
