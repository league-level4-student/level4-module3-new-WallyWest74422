package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {

	/*
	 * You are hosting a rainbow zombie conga dance party! Zombies are not very
	 * smart(maybe that's why they crave brains) and need your help to direct them
	 * through the choreography.
	 * 
	 * Each method is a dance move you will need to implement.
	 * 
	 * When you think you've gotten your zombies trained well enough you can start
	 * the party by running the main method in RainbowZombieDanceParty and typing
	 * how many rounds you want in the console to see if they followed your
	 * choreography correctly.
	 * 
	 * Note: The party will always start with a rainbow brains and every 5 rounds
	 * the head and tail of the dance line will be removed.
	 */

	private LinkedList<Zombie> congaLine;
	private ZombieHatColor[] zombieHats;

	public RainbowZombieCongaLine() {

		congaLine = new LinkedList<Zombie>();
		zombieHats = ZombieHatColor.values();

	}

	// Make the passed in zombie the first Zombie in the conga line!
	public void engine(Zombie dancer) {
		Node<Zombie> head = new Node<Zombie>(dancer);
		congaLine.setHead(head);
	}

	// Make the passed in zombie the last Zombie in the conga line!
	public void caboose(Zombie dancer) {
		Node<Zombie> tail = new Node<Zombie>(dancer);
		congaLine.setHead(tail);
	}

	// Place the zombie at the designated position in the conga line!
	public void jumpInTheLine(Zombie dancer, int position) {
		congaLine.add(dancer);
		position = dancer.hashCode();

	}

	/*
	 * Remove all zombies with the same hat color as the passed in zombie from the
	 * conga line!
	 */
	public void everyoneOut(Zombie dancer) {
		Node<Zombie> current = congaLine.getTail();
		Node<Zombie> previous = current.getPrev();
		while (current.getPrev() != null) {
			if (current.getValue().getZombieHatColor().equals(dancer.getZombieHatColor())) {
				congaLine.remove(dancer.hashCode());
			}
			current = current.getPrev();
		}
	}

	/*
	 * Remove the first zombie with the same hat color as the passed in zombie from
	 * the conga line!
	 */
	public void youAreDone(Zombie dancer) {
		boolean removed = false;
		Node<Zombie> current = congaLine.getTail();
		while (removed = false) {
			while (current.getPrev() != null) {
				if (current.getValue().getZombieHatColor().equals(dancer.getZombieHatColor())) {
					congaLine.remove(dancer.hashCode());
					removed = true;
				}
				current = current.getPrev();
			}
		}
	}

	/*
	 * Make two more zombies with the same hat color as the passed in zombie and add
	 * one to the front, one to the end and one in the middle.
	 */
	public void brains(Zombie dancer) {
		int middle = (congaLine.getHead().hashCode()+congaLine.getTail().hashCode())/2;
		Zombie new1 = new Zombie(dancer.getZombieHatColor());
		Zombie new2 = new Zombie(dancer.getZombieHatColor());
		Node<Zombie> front = new Node<Zombie>(new1);
		Node<Zombie> mid = new Node<Zombie>(new2);
		congaLine.setHead(front);
		middle = mid.hashCode();
		Node<Zombie> end = new Node<Zombie>(dancer);
		congaLine.setTail(end);
		
	}

	/*
	 * Add the passed in zombie to the front and then add one zombie of each hat
	 * color to the end of the line.
	 */
	public void rainbowBrains(Zombie dancer) {
		Node<Zombie> head = new Node<Zombie>(dancer);
		congaLine.setHead(head);
		Zombie r = new Zombie(ZombieHatColor.R);
		Zombie o = new Zombie(ZombieHatColor.O);
		Zombie y = new Zombie(ZombieHatColor.Y);
		Zombie g = new Zombie(ZombieHatColor.G);
		Zombie b = new Zombie(ZombieHatColor.B);
		Zombie i = new Zombie(ZombieHatColor.I);
		Zombie v = new Zombie(ZombieHatColor.V);
		Node<Zombie> red = new Node<Zombie>(r);
		congaLine.setTail(red);
		Node<Zombie> orange = new Node<Zombie>(o);
		congaLine.setTail(orange);
		orange = red.getNext();
		Node<Zombie> yellow = new Node<Zombie>(y);
		congaLine.setTail(yellow);
		yellow = orange.getNext();
		Node<Zombie> green = new Node<Zombie>(g);
		congaLine.setTail(green);
		green = yellow.getNext();
		Node<Zombie> blue = new Node<Zombie>(b);
		congaLine.setTail(blue);
		blue = green.getNext();
		Node<Zombie> indigo = new Node<Zombie>(i);
		congaLine.setTail(indigo);
		indigo = blue.getNext();
		Node<Zombie> violet = new Node<Zombie>(v);
		congaLine.setTail(violet);
		violet = indigo.getNext();
	}

	public LinkedList<Zombie> getCongaLine() {
		return congaLine;
	}
}
