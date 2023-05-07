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
		congaLine.add(dancer);
		congaLine.setHead(head);
	}

	// Make the passed in zombie the last Zombie in the conga line!
	public void caboose(Zombie dancer) {
		Node<Zombie> tail = new Node<Zombie>(dancer);
		congaLine.add(dancer);
	}

	// Place the zombie at the designated position in the conga line!
	public void jumpInTheLine(Zombie dancer, int position) {
		congaLine.add(dancer);
		Node<Zombie> pos = new Node<Zombie>(dancer);
		int spot = 0;
		Node<Zombie> current = congaLine.getHead();
		while (current != null) {
			if (spot == position) {
				current.setNext(pos);
 			}
			current = current.getNext();
			spot = spot + 1;
		}

	}

	/*
	 * Remove all zombies with the same hat color as the passed in zombie from the
	 * conga line!
	 */
	public void everyoneOut(Zombie dancer) {
		int spot = 0;
		Node<Zombie> current = congaLine.getHead();
//		Node<Zombie> previous = current.getPrev();
		while (current != null) {
			if (current.getValue().getZombieHatColor().equals(dancer.getZombieHatColor())) {
				congaLine.remove(spot);
			}
			current = current.getNext();
			spot = spot + 1;
		}
	}

	/*
	 * Remove the first zombie with the same hat color as the passed in zombie from
	 * the conga line!
	 */
	public void youAreDone(Zombie dancer) {
		int spot = 0;
		Node<Zombie> current = congaLine.getHead();
		while (current.getNext() != null) {
			if ((current.getValue().getZombieHatColor()).equals(dancer.getZombieHatColor())) {
				congaLine.remove(spot);
				break;
			}
			current = current.getNext();
			spot = spot +1;
		}

	}

	/*
	 * Make two more zombies with the same hat color as the passed in zombie and add
	 * one to the front, one to the end and one in the middle.
	 */
	public void brains(Zombie dancer) {
		int middle = (congaLine.size()/2)-1;
		Zombie new1 = new Zombie(dancer.getZombieHatColor());
		Zombie new2 = new Zombie(dancer.getZombieHatColor());
		congaLine.add(new1);
		congaLine.add(new2);
		Node<Zombie> front = new Node<Zombie>(new1);
		Node<Zombie> end = new Node<Zombie>(new2);
		congaLine.setHead(front);
		congaLine.setTail(end);
		congaLine.add(dancer);
		Node<Zombie> mid = new Node<Zombie>(dancer);
		int spot = 0;
		Node<Zombie> current = congaLine.getHead();
		while (current != null) {
			if (spot == middle) {
				current.setNext(mid);
 			}
			current = current.getNext();
			spot = spot + 1;
		}
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
		congaLine.add(r);
		congaLine.add(o);
		congaLine.add(y);
		congaLine.add(g);
		congaLine.add(b);
		congaLine.add(i);
		congaLine.add(v);
	}

	public LinkedList<Zombie> getCongaLine() {
		return congaLine;
	}
}
