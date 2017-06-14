package singlePlayer;

import javax.swing.ImageIcon;

public class CharacterImages {

	public ImageIcon [] wMoveN ,wMoveW , wMoveE , wMoveS , wMoveNW , wMoveNE , wMoveSE , wMoveSW;
	public ImageIcon [] wWorkN ,wWorkW , wWorkE , wWorkS , wWorkNW , wWorkNE , wWorkSE , wWorkSW;
	public ImageIcon [] sMoveN ,sMoveW , sMoveE , sMoveS , sMoveNW , sMoveNE , sMoveSE , sMoveSW;
	public ImageIcon [] sAttackN ,sAttackW , sAttackE , sAttackS , sAttackNW , sAttackNE , sAttackSE , sAttackSW;
	public ImageIcon [] sDieN ,sDieW , sDieE , sDieS , sDieNW , sDieNE , sDieSE , sDieSW;
	public ImageIcon [] shMoveN ,shMoveW , shMoveE , shMoveS , shMoveNW , shMoveNE , shMoveSE , shMoveSW;
	public ImageIcon [] fMoveN ,fMoveW , fMoveE , fMoveS , fMoveNW , fMoveNE , fMoveSE , fMoveSW;
	public ImageIcon [] fGetN ,fGetW , fGetE , fGetS , fGetNW , fGetNE , fGetSE , fGetSW;
	public ImageIcon [][][] getCharacterImage;

	public CharacterImages() {
		// TODO Auto-generated constructor stub
		getCharacterImage = new ImageIcon[8][8][3];
		initializeAllImage();
		///////0.WorkerMove 1.WorkerWork 2.Soldier Move 3.Soldier Attack 4.Soldier Die 5.Moving Ship 6.Moving FishingShip 7.Fishing
		//worker move
		for(int i = 0 ; i<3 ; i++){
			getCharacterImage [0][0][i] = wMoveN[i] ;
			getCharacterImage [0][1][i] = wMoveNW[i] ;
			getCharacterImage [0][2][i] = wMoveW[i] ;
			getCharacterImage [0][3][i] = wMoveSW[i] ;
			getCharacterImage [0][4][i] = wMoveS[i] ;
			getCharacterImage [0][5][i] = wMoveSE[i] ;
			getCharacterImage [0][6][i] = wMoveE[i] ;
			getCharacterImage [0][7][i] = wMoveNE[i] ;
		}
		//worker farm
		for(int i = 0 ; i<3 ; i++){
			getCharacterImage [1][0][i] = wWorkN[i] ;
			getCharacterImage [1][1][i] = wWorkNW[i] ;
			getCharacterImage [1][2][i] = wWorkW[i] ;
			getCharacterImage [1][3][i] = wWorkSW[i] ;
			getCharacterImage [1][4][i] = wWorkS[i] ;
			getCharacterImage [1][5][i] = wWorkSE[i] ;
			getCharacterImage [1][6][i] = wWorkE[i] ;
			getCharacterImage [1][7][i] = wWorkNE[i] ;
		}
		//soldier move
		for(int i = 0 ; i<3 ; i++){
			getCharacterImage [2][0][i] = sMoveN[i] ;
			getCharacterImage [2][1][i] = sMoveNW[i] ;
			getCharacterImage [2][2][i] = sMoveW[i] ;
			getCharacterImage [2][3][i] = sMoveSW[i] ;
			getCharacterImage [2][4][i] = sMoveS[i] ;
			getCharacterImage [2][5][i] = sMoveSE[i] ;
			getCharacterImage [2][6][i] = sMoveE[i] ;
			getCharacterImage [2][7][i] = sMoveNE[i] ;
		}
		//soldier attack
		for(int i = 0 ; i<3 ; i++){
			getCharacterImage [3][0][i] = sAttackN[i] ;
			getCharacterImage [3][1][i] = sAttackNW[i] ;
			getCharacterImage [3][2][i] = sAttackW[i] ;
			getCharacterImage [3][3][i] = sAttackSW[i] ;
			getCharacterImage [3][4][i] = sAttackS[i] ;
			getCharacterImage [3][5][i] = sAttackSE[i] ;
			getCharacterImage [3][6][i] = sAttackE[i] ;
			getCharacterImage [3][7][i] = sAttackNE[i] ;
		}
		//soldier die
			for(int i = 0 ; i<3 ; i++){
				getCharacterImage [4][0][i] = sDieN[i] ;
				getCharacterImage [4][1][i] = sDieNW[i] ;
				getCharacterImage [4][2][i] = sDieW[i] ;
				getCharacterImage [4][3][i] = sDieSW[i] ;
				getCharacterImage [4][4][i] = sDieS[i] ;
				getCharacterImage [4][5][i] = sDieSE[i] ;
				getCharacterImage [4][6][i] = sDieE[i] ;
				getCharacterImage [4][7][i] = sDieNE[i] ;
			}
			//Moving Ship
			for(int i = 0 ; i<3 ; i++){
				getCharacterImage [5][0][i] = shMoveN[i] ;
				getCharacterImage [5][1][i] = shMoveNW[i] ;
				getCharacterImage [5][2][i] = shMoveW[i] ;
				getCharacterImage [5][3][i] = shMoveSW[i] ;
				getCharacterImage [5][4][i] = shMoveS[i] ;
				getCharacterImage [5][5][i] = shMoveSE[i] ;
				getCharacterImage [5][6][i] = shMoveE[i] ;
				getCharacterImage [5][7][i] = shMoveNE[i] ;
			}
			//Moving FishingShip
			for(int i = 0 ; i<3 ; i++){
				getCharacterImage [6][0][i] = fMoveN[i] ;
				getCharacterImage [6][1][i] = fMoveNW[i] ;
				getCharacterImage [6][2][i] = fMoveW[i] ;
				getCharacterImage [6][3][i] = fMoveSW[i] ;
				getCharacterImage [6][4][i] = fMoveS[i] ;
				getCharacterImage [6][5][i] = fMoveSE[i] ;
				getCharacterImage [6][6][i] = fMoveE[i] ;
				getCharacterImage [6][7][i] = fMoveNE[i] ;
			}
			//Fishing
			for(int i = 0 ; i<3 ; i++){
				getCharacterImage [7][0][i] = fGetN[i] ;
				getCharacterImage [7][1][i] = fGetNW[i] ;
				getCharacterImage [7][2][i] = fGetW[i] ;
				getCharacterImage [7][3][i] = fGetSW[i] ;
				getCharacterImage [7][4][i] = fGetS[i] ;
				getCharacterImage [7][5][i] = fGetSE[i] ;
				getCharacterImage [7][6][i] = fGetE[i] ;
				getCharacterImage [7][7][i] = fGetNE[i] ;
			}


		}
	
	
		public ImageIcon currentTile(int i , int j , int k){
			return getCharacterImage[i][j][k];
		}

		public void initializeAllImage(){
			//worker moving
			wMoveN = new ImageIcon[3];
			wMoveNW = new ImageIcon[3];
			wMoveW = new ImageIcon[3];
			wMoveSW = new ImageIcon[3];
			wMoveS = new ImageIcon[3];
			wMoveSE = new ImageIcon[3];
			wMoveE = new ImageIcon[3];
			wMoveNE = new ImageIcon[3];

			//worker working
			wWorkN = new ImageIcon[3];
			wWorkNW = new ImageIcon[3];
			wWorkW = new ImageIcon[3];
			wWorkSW = new ImageIcon[3];
			wWorkS = new ImageIcon[3];
			wWorkSE = new ImageIcon[3];
			wWorkE = new ImageIcon[3];
			wWorkNE = new ImageIcon[3];

			//soldier move
			sMoveN = new ImageIcon[3];
			sMoveNW = new ImageIcon[3];
			sMoveW = new ImageIcon[3];
			sMoveSW = new ImageIcon[3];
			sMoveS = new ImageIcon[3];
			sMoveSE = new ImageIcon[3];
			sMoveE = new ImageIcon[3];
			sMoveNE = new ImageIcon[3];

			//soldier attack
			sAttackN = new ImageIcon[3];
			sAttackNW = new ImageIcon[3];
			sAttackW = new ImageIcon[3];
			sAttackSW = new ImageIcon[3];
			sAttackS = new ImageIcon[3];
			sAttackSE = new ImageIcon[3];
			sAttackE = new ImageIcon[3];
			sAttackNE = new ImageIcon[3];

			//soldier die
			sDieN = new ImageIcon[3];
			sDieNW = new ImageIcon[3];
			sDieW = new ImageIcon[3];
			sDieSW = new ImageIcon[3];
			sDieS = new ImageIcon[3];
			sDieSE = new ImageIcon[3];
			sDieE = new ImageIcon[3];
			sDieNE = new ImageIcon[3];

			//ship Moving
			shMoveN = new ImageIcon[3];
			shMoveN[0] = new ImageIcon("images\\ship\\ship_n.png");
			shMoveN[1] = shMoveN[0];		shMoveN[2] = shMoveN[0];
			shMoveNW = new ImageIcon[3];
			shMoveNW[0]= new ImageIcon("images\\ship\\ship_ne.png");
			shMoveNW[1] = shMoveNW[0];		shMoveNW[2] = shMoveNW[0];
			shMoveW = new ImageIcon[3];
			shMoveW[0] = new ImageIcon("images\\ship\\ship_w.png");
			shMoveW[1] = shMoveW[0];		shMoveW[2] = shMoveW[0];
			shMoveSW = new ImageIcon[3];
			shMoveSW[0] = new ImageIcon("images\\ship\\ship_sw.png");
			shMoveSW[1] = shMoveSW[0];		shMoveSW[2] = shMoveSW[0];
			shMoveS = new ImageIcon[3];
			shMoveS[0] = new ImageIcon("images\\ship\\ship_s.png");
			shMoveS[1] = shMoveS[0];		shMoveS[2] = shMoveS[0];
			shMoveSE = new ImageIcon[3];
			shMoveSE[0] = new ImageIcon("images\\ship\\ship_se.png");
			shMoveSE[1] = shMoveSE[0];		shMoveSE[2] = shMoveSE[0];
			shMoveE = new ImageIcon[3];
			shMoveE[0] = new ImageIcon("images\\ship\\ship_e.png");
			shMoveE[1] = shMoveE[0];		shMoveE[2] = shMoveE[0];
			shMoveNE = new ImageIcon[3];
			shMoveNE[0] = new ImageIcon("images\\ship\\ship_ne.png");
			shMoveNE[1] = shMoveNE[0];		shMoveNE[2] = shMoveNE[0];

			//Fishing Ship Moving
			fMoveN = new ImageIcon[3];
			fMoveN[0] = new ImageIcon("images\\fishingShip\\fishingShip_n.png");
			fMoveN[1] = fMoveN[0];		fMoveN[2] = fMoveN[0];
			fMoveNW = new ImageIcon[3];
			fMoveNW[0]= new ImageIcon("images\\fishingShip\\fishingShip_ne.png");
			fMoveNW[1] = fMoveNW[0];		fMoveNW[2] = fMoveNW[0];
			fMoveW = new ImageIcon[3];
			fMoveW[0] = new ImageIcon("images\\fishingShip\\fishingShip_w.png");
			fMoveW[1] = fMoveW[0];		fMoveW[2] = fMoveW[0];
			fMoveSW = new ImageIcon[3];
			fMoveSW[0] = new ImageIcon("images\\fishingShip\\fishingShip_sw.png");
			fMoveSW[1] = fMoveSW[0];		fMoveSW[2] = fMoveSW[0];
			fMoveS = new ImageIcon[3];
			fMoveS[0] = new ImageIcon("images\\fishingShip\\fishingShip_s.png");
			fMoveS[1] = fMoveS[0];		fMoveS[2] = fMoveS[0];
			fMoveSE = new ImageIcon[3];
			fMoveSE[0] = new ImageIcon("images\\fishingShip\\fishingShip_se.png");
			fMoveSE[1] = fMoveSE[0];		fMoveSE[2] = fMoveSE[0];
			fMoveE = new ImageIcon[3];
			fMoveE[0] = new ImageIcon("images\\fishingShip\\fishingShip_e.png");
			fMoveE[1] = fMoveE[0];		fMoveE[2] = fMoveE[0];
			fMoveNE = new ImageIcon[3];
			fMoveNE[0] = new ImageIcon("images\\fishingShip\\fishingShip_ne.png");
			fMoveNE[1] = fMoveNE[0];		fMoveNE[2] = fMoveNE[0];

			//Fishing getting Fish
			fGetN = new ImageIcon[3];
			fGetN[0] = new ImageIcon("images\\fishingShip\\fishingShip_fishing.png");
			fGetN[1] = fGetN[0] ; fGetN[2] = fGetN[0];
			fGetNW = new ImageIcon[3];
			fGetNW[0] = fGetN[0] ;fGetNW[1] = fGetN[0] ; fGetNW[2] = fGetN[0];
			fGetW = new ImageIcon[3];
			fGetW[0] = fGetN[0] ;fGetW[1] = fGetN[0] ; fGetW[2] = fGetN[0];
			fGetSW = new ImageIcon[3];
			fGetSW[0] = fGetN[0] ;fGetSW[1] = fGetN[0] ; fGetSW[2] = fGetN[0];
			fGetS = new ImageIcon[3];
			fGetS[0] = fGetN[0] ;fGetS[1] = fGetN[0] ; fGetS[2] = fGetN[0];
			fGetSE = new ImageIcon[3];
			fGetSE[0] = fGetN[0] ; fGetSE[1] = fGetN[0] ; fGetSE[2] = fGetN[0];
			fGetE = new ImageIcon[3];
			fGetE[0] = fGetN[0] ; fGetE[1] = fGetN[0] ; fGetE[2] = fGetN[0];
			fGetNE = new ImageIcon[3];
			fGetNE[0] = fGetN[0] ; fGetNE[1] = fGetN[0] ; fGetNE[2] = fGetN[0];
			
			
			StringBuilder wMove = new StringBuilder("images\\Worker\\Move\\");
			StringBuilder wWork = new StringBuilder("images\\Worker\\Work\\");
			StringBuilder sMove = new StringBuilder("images\\Soldier\\Blue\\Move\\");
			StringBuilder sAttack = new StringBuilder("images\\Soldier\\Blue\\Attack\\");
			StringBuilder sDie = new StringBuilder("images\\Soldier\\Blue\\Die\\");
			for (int i = 0; i < 3; i++) {
				//////////////////////////////////////////worker moving
				wMove.append("n");
				wMove.append(i+1);
				wMove.append(".PNG");
				wMoveN[i] = new ImageIcon(wMove.toString());
				wMove.setLength(wMove.length() - 6);


				wMove.append("nw");
				wMove.append(i+1);
				wMove.append(".PNG");
				wMoveNW[i] = new ImageIcon(wMove.toString());
				wMove.setLength(wMove.length() - 7);

				wMove.append("w");
				wMove.append(i+1);
				wMove.append(".PNG");
				wMoveW[i] = new ImageIcon(wMove.toString());
				wMove.setLength(wMove.length() - 6);

				wMove.append("sw");
				wMove.append(i+1);
				wMove.append(".PNG");
				wMoveSW[i] = new ImageIcon(wMove.toString());
				wMove.setLength(wMove.length() - 7);

				wMove.append("s");
				wMove.append(i+1);
				wMove.append(".PNG");
				wMoveS[i] = new ImageIcon(wMove.toString());
				wMove.setLength(wMove.length() - 6);

				wMove.append("se");
				wMove.append(i+1);
				wMove.append(".PNG");
				wMoveSE[i] = new ImageIcon(wMove.toString());
				wMove.setLength(wMove.length() - 7);

				wMove.append("e");
				wMove.append(i+1);
				wMove.append(".PNG");
				wMoveE[i] = new ImageIcon(wMove.toString());
				wMove.setLength(wMove.length() - 6);

				wMove.append("ne");
				wMove.append(i+1);
				wMove.append(".PNG");
				wMoveNE[i] = new ImageIcon(wMove.toString());
				wMove.setLength(wMove.length() - 7);

				//////////////////////////////////////worker working
				wWork.append("n");
				wWork.append(i+1);
				wWork.append(".PNG");
				wWorkN[i] = new ImageIcon(wWork.toString());
				wWork.setLength(wWork.length() - 6);


				wWork.append("nw");
				wWork.append(i+1);
				wWork.append(".PNG");
				wWorkNW[i] = new ImageIcon(wWork.toString());
				wWork.setLength(wWork.length() - 7);

				wWork.append("w");
				wWork.append(i+1);
				wWork.append(".PNG");
				wWorkW[i] = new ImageIcon(wWork.toString());
				wWork.setLength(wWork.length() - 6);

				wWork.append("sw");
				wWork.append(i+1);
				wWork.append(".PNG");
				wWorkSW[i] = new ImageIcon(wWork.toString());
				wWork.setLength(wWork.length() - 7);

				wWork.append("s");
				wWork.append(i+1);
				wWork.append(".PNG");
				wWorkS[i] = new ImageIcon(wWork.toString());
				wWork.setLength(wWork.length() - 6);

				wWork.append("se");
				wWork.append(i+1);
				wWork.append(".PNG");
				wWorkSE[i] = new ImageIcon(wWork.toString());
				wWork.setLength(wWork.length() - 7);

				wWork.append("e");
				wWork.append(i+1);
				wWork.append(".PNG");
				wWorkE[i] = new ImageIcon(wWork.toString());
				wWork.setLength(wWork.length() - 6);

				wWork.append("ne");
				wWork.append(i+1);
				wWork.append(".PNG");
				wWorkNE[i] = new ImageIcon(wWork.toString());
				wWork.setLength(wWork.length() - 7);

				//////////////////////////soldier moving
				sMove.append("n");
				sMove.append(i+1);
				sMove.append(".PNG");
				sMoveN[i] = new ImageIcon(sMove.toString());
				sMove.setLength(sMove.length() - 6);


				sMove.append("nw");
				sMove.append(i+1);
				sMove.append(".PNG");
				sMoveNW[i] = new ImageIcon(sMove.toString());
				sMove.setLength(sMove.length() - 7);

				sMove.append("w");
				sMove.append(i+1);
				sMove.append(".PNG");
				sMoveW[i] = new ImageIcon(sMove.toString());
				sMove.setLength(sMove.length() - 6);

				sMove.append("sw");
				sMove.append(i+1);
				sMove.append(".PNG");
				sMoveSW[i] = new ImageIcon(sMove.toString());
				sMove.setLength(sMove.length() - 7);

				sMove.append("s");
				sMove.append(i+1);
				sMove.append(".PNG");
				sMoveS[i] = new ImageIcon(sMove.toString());
				sMove.setLength(sMove.length() - 6);

				sMove.append("se");
				sMove.append(i+1);
				sMove.append(".PNG");
				sMoveSE[i] = new ImageIcon(sMove.toString());
				sMove.setLength(sMove.length() - 7);

				sMove.append("e");
				sMove.append(i+1);
				sMove.append(".PNG");
				sMoveE[i] = new ImageIcon(sMove.toString());
				sMove.setLength(sMove.length() - 6);

				sMove.append("ne");
				sMove.append(i+1);
				sMove.append(".PNG");
				sMoveNE[i] = new ImageIcon(sMove.toString());
				sMove.setLength(sMove.length() - 7);

				/////////////////////////////////////soldier attack
				sAttack.append("n");
				sAttack.append(i+1);
				sAttack.append(".PNG");
				sAttackN[i] = new ImageIcon(sAttack.toString());
				sAttack.setLength(sAttack.length() - 6);


				sAttack.append("nw");
				sAttack.append(i+1);
				sAttack.append(".PNG");
				sAttackNW[i] = new ImageIcon(sAttack.toString());
				sAttack.setLength(sAttack.length() - 7);

				sAttack.append("w");
				sAttack.append(i+1);
				sAttack.append(".PNG");
				sAttackW[i] = new ImageIcon(sAttack.toString());
				sAttack.setLength(sAttack.length() - 6);

				sAttack.append("sw");
				sAttack.append(i+1);
				sAttack.append(".PNG");
				sAttackSW[i] = new ImageIcon(sAttack.toString());
				sAttack.setLength(sAttack.length() - 7);

				sAttack.append("s");
				sAttack.append(i+1);
				sAttack.append(".PNG");
				sAttackS[i] = new ImageIcon(sAttack.toString());
				sAttack.setLength(sAttack.length() - 6);

				sAttack.append("se");
				sAttack.append(i+1);
				sAttack.append(".PNG");
				sAttackSE[i] = new ImageIcon(sAttack.toString());
				sAttack.setLength(sAttack.length() - 7);

				sAttack.append("e");
				sAttack.append(i+1);
				sAttack.append(".PNG");
				sAttackE[i] = new ImageIcon(sAttack.toString());
				sAttack.setLength(sAttack.length() - 6);

				sAttack.append("ne");
				sAttack.append(i+1);
				sAttack.append(".PNG");
				sAttackNE[i] = new ImageIcon(sAttack.toString());
				sAttack.setLength(sAttack.length() - 7);

				///////////////////////////////soldier die
				sDie.append("n");
				sDie.append(i+1);
				sDie.append(".PNG");
				sDieN[i] = new ImageIcon(sDie.toString());
				sDie.setLength(sDie.length() - 6);


				sDie.append("nw");
				sDie.append(i+1);
				sDie.append(".PNG");
				sDieNW[i] = new ImageIcon(sDie.toString());
				sDie.setLength(sDie.length() - 7);

				sDie.append("w");
				sDie.append(i+1);
				sDie.append(".PNG");
				sDieW[i] = new ImageIcon(sDie.toString());
				sDie.setLength(sDie.length() - 6);

				sDie.append("sw");
				sDie.append(i+1);
				sDie.append(".PNG");
				sDieSW[i] = new ImageIcon(sDie.toString());
				sDie.setLength(sDie.length() - 7);

				sDie.append("s");
				sDie.append(i+1);
				sDie.append(".PNG");
				sDieS[i] = new ImageIcon(sDie.toString());
				sDie.setLength(sDie.length() - 6);

				sDie.append("se");
				sDie.append(i+1);
				sDie.append(".PNG");
				sDieSE[i] = new ImageIcon(sDie.toString());
				sDie.setLength(sDie.length() - 7);

				sDie.append("e");
				sDie.append(i+1);
				sDie.append(".PNG");
				sDieE[i] = new ImageIcon(sDie.toString());
				sDie.setLength(sDie.length() - 6);

				sDie.append("ne");
				sDie.append(i+1);
				sDie.append(".PNG");
				sDieNE[i] = new ImageIcon(sDie.toString());
				sDie.setLength(sDie.length() - 7);

			}

		}



		public ImageIcon[] getwMoveN() {
			return wMoveN;
		}

		public ImageIcon[] getwMoveW() {
			return wMoveW;
		}

		public ImageIcon[] getwMoveE() {
			return wMoveE;
		}

		public ImageIcon[] getwMoveS() {
			return wMoveS;
		}

		public ImageIcon[] getwMoveNW() {
			return wMoveNW;
		}

		public ImageIcon[] getwMoveNE() {
			return wMoveNE;
		}

		public ImageIcon[] getwMoveSE() {
			return wMoveSE;
		}

		public ImageIcon[] getwMoveSW() {
			return wMoveSW;
		}

		public ImageIcon[] getwWorkN() {
			return wWorkN;
		}

		public ImageIcon[] getwWorkW() {
			return wWorkW;
		}

		public ImageIcon[] getwWorkE() {
			return wWorkE;
		}

		public ImageIcon[] getwWorkS() {
			return wWorkS;
		}

		public ImageIcon[] getwWorkNW() {
			return wWorkNW;
		}

		public ImageIcon[] getwWorkNE() {
			return wWorkNE;
		}

		public ImageIcon[] getwWorkSE() {
			return wWorkSE;
		}

		public ImageIcon[] getwWorkSW() {
			return wWorkSW;
		}

		public ImageIcon[] getsMoveN() {
			return sMoveN;
		}

		public ImageIcon[] getsMoveW() {
			return sMoveW;
		}

		public ImageIcon[] getsMoveE() {
			return sMoveE;
		}

		public ImageIcon[] getsMoveS() {
			return sMoveS;
		}

		public ImageIcon[] getsMoveNW() {
			return sMoveNW;
		}

		public ImageIcon[] getsMoveNE() {
			return sMoveNE;
		}

		public ImageIcon[] getsMoveSE() {
			return sMoveSE;
		}

		public ImageIcon[] getsMoveSW() {
			return sMoveSW;
		}

		public ImageIcon[] getsAttackN() {
			return sAttackN;
		}

		public ImageIcon[] getsAttackW() {
			return sAttackW;
		}

		public ImageIcon[] getsAttackE() {
			return sAttackE;
		}

		public ImageIcon[] getsAttackS() {
			return sAttackS;
		}

		public ImageIcon[] getsAttackNW() {
			return sAttackNW;
		}

		public ImageIcon[] getsAttackNE() {
			return sAttackNE;
		}

		public ImageIcon[] getsAttackSE() {
			return sAttackSE;
		}

		public ImageIcon[] getsAttackSW() {
			return sAttackSW;
		}

		public ImageIcon[] getsDieN() {
			return sDieN;
		}

		public ImageIcon[] getsDieW() {
			return sDieW;
		}

		public ImageIcon[] getsDieE() {
			return sDieE;
		}

		public ImageIcon[] getsDieS() {
			return sDieS;
		}

		public ImageIcon[] getsDieNW() {
			return sDieNW;
		}

		public ImageIcon[] getsDieNE() {
			return sDieNE;
		}

		public ImageIcon[] getsDieSE() {
			return sDieSE;
		}

		public ImageIcon[] getsDieSW() {
			return sDieSW;
		}



	}
