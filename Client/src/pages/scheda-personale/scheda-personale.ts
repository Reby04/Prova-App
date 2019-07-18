import { Component } from '@angular/core';
import { IonicPage, LoadingController, NavController, NavParams, AlertController } from 'ionic-angular';
import { Utente } from '../../models/utente.model';
import { AccountProvider } from '../../providers/account.provider';
import { SchedaPersonaleService } from '../../providers/schedaPersonale.provider';
import { schedaPersonale } from '../../models/schedaPersonale.model';
import { Esercizio } from '../../models/esercizio.model';

/**
 * Generated class for the SchedaPersonalePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-scheda-personale',
  templateUrl: 'scheda-personale.html',
  
})
export class SchedaPersonalePage {

  public utente: Utente;
  public id: String = ""; //id scheda
  public scheda: schedaPersonale = null;
  public esercizi: Array<Esercizio> = [];

  constructor(
    public navCtrl: NavController, 
    public navParams: NavParams, 
    public sAccount: AccountProvider, 
    public loadingCtrl : LoadingController,
    public alertCtrl: AlertController,
    public sService: SchedaPersonaleService
    ) {

    this.utente= this.sAccount.getUtente();
    this.id= this.navParams.get("id");

    const loading = this.loadingCtrl.create({content: "Caricamento"});
    loading.present();
    this.sService.getSchedaById(this.id)
        .then(scheda => {
            loading.dismiss().then(() =>{
                this.scheda = scheda;
                this.esercizi = scheda.esercizi;
                console.log("esercizi");
                console.log(this.esercizi);
            })
            
            
        }).catch(()=>{
            loading.dismiss().then(()=>{
                this.alertCtrl.create({
                    title: "FitWoman",
                    message: "Non è stato possibile caricare la scheda creata",
                    buttons: ['Ok']
                }).present();
            })
        });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad SchedaPersonalePage');
  }

  doAlert(esercizio: Esercizio) {
    let alert = this.alertCtrl.create({
      title: esercizio.nome,
      message: esercizio.descrizione,
      buttons: ['Ok']
    });
    alert.present()
  }



}
