package antoine;

import antoine.arbres.Tree;

public class Application {

    public static void main(String[] args) {
        Tree sag = new Tree(5, new Tree(3, null, null),
				new Tree(12, new Tree(8, new Tree(6, null, null), null), new Tree(13, null, null)));
		Tree sad = new Tree(25, new Tree(21, null, null), new Tree(28, null, null));
		Tree tree = new Tree(20, sag, sad);

		System.out.println("tree.afficheInfixe()");
		tree.afficheInfixe();
		System.out.println("tree.affichePrefixe()");
		tree.affichePrefixe();
		System.out.println("tree.afficheSuffixe()");
		tree.afficheSuffixe();

		//              /
		//          *       +
		//      -     D    A    +
		//  A C                B D   


		// infixe = dans l'ordre
		// prefixe = / * - A C D + A + B D
		// suffixe = A C - D * / A + B D +
    }
}
