import java.util.Scanner;
import RedeSocial.*;

public class Main {

	private static final String EXIT = "SAIR";
	private static final String CONSULT_PERSON = "CONSULTAPESSOA";
	private static final String REGISTER = "REGISTA";
	private static final String CONSULT_FRIENDSHIP = "CONSULTAAMIZADE";
	private static final String FRIENDS = "AMIGOS";
	private static final String CONSULT_FRIENDS = "CONSULTAAMIGOS";
	private static final String NEW_STATE = "NOVOESTADO";
	private static final String CONSULT_STATE = "CONSULTAESTADO";
	private static final String PEOPLE = "PESSOAS";
	private static final String POST_PUBLIC = "POSTARPUBLICO";
	private static final String POST_FRIEND_MURAL = "POSTAR";
	private static final String LIST_MURAL = "MURAL";

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		FacebookSystem sistema = new FacebookSystemClass();
		String option;

		do {
			option = in.nextLine();
			executeOption(option, sistema, in);
		} while (!option.equals(EXIT));
		in.close();
		

	}

	private static void executeOption(String option, FacebookSystem sistema, Scanner in) {

		switch (option) {
		case CONSULT_PERSON:
			consultPerson(in, sistema);
			break;
		case REGISTER:
			register(in, sistema);
			break;
		case CONSULT_FRIENDSHIP:
			consultFriendship(in, sistema);
			break;
		case FRIENDS:
			friends(in, sistema);
			break;
		case CONSULT_FRIENDS:
			consultFriends(in, sistema);
			break;
		case NEW_STATE:
			changeState(in, sistema);
			break;
		case CONSULT_STATE:
			listState(in, sistema);
			break;
		case PEOPLE:
			listUsers(in, sistema);
			break;
		case POST_PUBLIC:
			postPublic(in, sistema);
			break;
		case POST_FRIEND_MURAL:
			postToFriend(in , sistema);
			break;
		case LIST_MURAL:
			listMural(in, sistema);
			break;
		case EXIT:
			exit();
			break;

		}

	}

	/**
	 * Is to see if a person is registered in the system
	 * 
	 * @param in      is the scanner
	 * @param sistema is the global system
	 */
	private static void consultPerson(Scanner in, FacebookSystem sistema) {

		String name = in.nextLine();

		if (sistema.isRegistered(name) == true) {
			System.out.println("Pessoa registada.\n");
			
		} else {
			System.out.println("Sem registo.\n");
			
		}
	}

	/**
	 * Registers a new user
	 * 
	 * @param in      is to use the scanner
	 * @param sistema is to use the global system
	 */
	private static void register(Scanner in, FacebookSystem sistema) {

		String name = in.nextLine();
		String mail = in.nextLine();
		String state = in.nextLine();

		if (sistema.isRegistered(name) == false) {
			sistema.registerPerson(name, mail, state);
			System.out.println("Pessoa registada com sucesso.\n");
			
		} else {
			System.out.println("Pessoa registada.\n");
			
		}
	}

	/**
	 * Is to see if 2 people are friends or not
	 * 
	 * @param in      is to use the scanner
	 * @param sistema is to use the global system
	 */
	private static void consultFriendship(Scanner in, FacebookSystem sistema) {

		String name = in.nextLine();
		String otherName = in.nextLine();

		if (sistema.isFriendshipExistent(name, otherName) == true) {
			System.out.println("Amizade existente.\n");
		} else {
			System.out.println("Amizade inexistente.\n");
		}
	}

	/**
	 * Add a new friend to your friends list
	 * 
	 * @param in      is the scanner
	 * @param sistema is the global system
	 */
	private static void friends(Scanner in, FacebookSystem sistema) {

		String name = in.nextLine();
		String otherName = in.nextLine();

		if (sistema.isRegistered(name) == false || sistema.isRegistered(otherName) == false) {
			System.out.println("Sem registo.\n");
		} else if (sistema.isFriendshipExistent(name, otherName) == true) {
			System.out.println("Amizade existente.\n");
		} else if (name.equals(otherName)) {
			System.out.println("Amizade invalida.\n");
		} else {
			sistema.addFriend(name, otherName);
			System.out.println("Amizade criada.\n");
		}
	}

	/**
	 * Lists the friend list
	 * 
	 * @param in      scanner
	 * @param sistema global system
	 */
	private static void consultFriends(Scanner in, FacebookSystem sistema) {

		String name = in.nextLine();

		if (sistema.isRegistered(name) == false) {
			System.out.println("Sem registo.\n");
		}

		Iterator iterator = sistema.listFriends(name);

		if (sistema.numberOfFriends(name) == 0) {
			System.out.println("Nao tem amigos registados.\n");
		} else {
			System.out.println("Lista de amigos:");
			while (iterator.hasNext()) {

				FriendRelationClass tmp = iterator.Next();
				System.out.println(tmp.getName() + "; " + tmp.getMail());
			}
			System.out.println();
		}
	}

	/**
	 * Changes the state of the user
	 * 
	 * @param in      scanner
	 * @param sistema global system
	 */
	private static void changeState(Scanner in, FacebookSystem sistema) {

		String name = in.nextLine();
		String state = in.nextLine();

		if (sistema.isRegistered(name) == false) {
			System.out.println("Sem registo.\n");
		} else {
			sistema.changeState(name, state);
			System.out.println("Estado alterado.\n");
		}

	}

	/**
	 * Return the state of the person
	 * 
	 * @param in      scanner
	 * @param sistema global system
	 */
	private static void listState(Scanner in, FacebookSystem sistema) {

		String name = in.nextLine();

		if (sistema.isRegistered(name) == false) {
			System.out.println("Sem registo.\n");
		} else {

			System.out.println(sistema.getState(name));
			System.out.println();
		}

	}

	/**
	 * Lists all the registered users
	 * 
	 * @param in      scanner
	 * @param sistema global system
	 */
	private static void listUsers(Scanner in, FacebookSystem sistema) {

		Iterator2 iterator = sistema.listUsers();

		if (sistema.getNumUsers() == 0) {

			System.out.println("Rede Social vazia.\n");
		} else {
			System.out.println("Lista de pessoas registadas:");
			while (iterator.hasNext()) {
				Person tmp = iterator.Next();
				System.out.println(tmp.getName() + "; " + tmp.getMail());
			}
			System.out.println();

		}

	}
	/**
	 * adds a post in your moral
	 * @param in scanner
	 * @param sistema facebook system
	 */
	private static void postPublic(Scanner in , FacebookSystem sistema) {
		
		String name = in.nextLine();
		String mesage = in.nextLine();
		
		if (sistema.isRegistered(name) == false) {
			System.out.println("Sem registo.\n");
		}else {
			sistema.postMessage(name, mesage);
			System.out.println("Post registado.\n");
		}
	}
	/**
	 * adds a post to your friend's mural
	 * 
	 * @param in scanner
	 * @param sistema facebook system
	 */
	private static void postToFriend(Scanner in, FacebookSystem sistema) {
		
		String whoSends = in.nextLine();
		String message = in.nextLine();
		String whoReceives = in.nextLine();
		
		if(sistema.isRegistered(whoSends) == false || sistema.isRegistered(whoReceives) == false) {
			System.out.println("Sem registo.\n");
		}else if(sistema.isFriendshipExistent(whoSends, whoReceives) == false) {
			System.out.println("Amizade inexistente.\n");
		}else {
			sistema.postToFriendMural(whoSends, message, whoReceives);
			System.out.println("Post registado.\n");
		}
	}
	/**
	 * lists the selected person's mural
	 * @param in scanner 
	 * @param sistema facebook system
	 */
	private static void listMural(Scanner in, FacebookSystem sistema) {
		
		String nomeAmigo = in.nextLine();
		String nomeDono = in.nextLine();
		
		if(sistema.isRegistered(nomeAmigo) == false || sistema.isRegistered(nomeDono) == false) {
			System.out.println("Sem registo.\n");
		}else if(sistema.isFriendshipExistent(nomeAmigo, nomeDono) == false) {
			System.out.println("Amizade inexistente.\n");
		}else {
			System.out.println("Mural de " + nomeDono + ":");
			Iterator3 tmp = sistema.listMural(nomeDono);
			while(tmp.hasNext()) {
				Mural mural = tmp.next();
				
					System.out.println("POST " + mural.getMessageOwner() + ": " + mural.getMessagePost());
				
			}
			System.out.println();
		}
		
	}
	private static void exit() {
		System.out.println("Adeus.\n");
	}

}
