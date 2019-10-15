//
//  ViewController.swift
//  Midterm
//
//  Created by Cady Speelman on 10/15/19.
//  Copyright © 2019 Cady Speelman. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    
    @IBOutlet weak var commuteMiles: UITextField!
    @IBOutlet weak var reportCommuteTime: UILabel!
    @IBOutlet weak var reportGasNeeded: UILabel!
    @IBOutlet weak var monthlySwitch: UISwitch!
    @IBOutlet weak var gallonsInTank: UILabel!
    @IBOutlet weak var transportImg: UIImageView!
    @IBOutlet weak var transportSegControl: UISegmentedControl!
    
    
    
    
    @IBAction func changeTransport(_ sender: UISegmentedControl) {//car
        if transportSegControl.selectedSegmentIndex == 0 {
            transportImg.image=UIImage(named: "car_icon")
        }else if (transportSegControl.selectedSegmentIndex == 1 ){//bus
            transportImg.image=UIImage(named: "bus_icon")
            reportGasNeeded.text = "0 gallons"
                let alert = UIAlertController(title: "Info", message: "A 10 minute wait time is added to total commute time for busing", preferredStyle: UIAlertController.Style.alert)
                let cancelAction = UIAlertAction(title: "Okay", style: UIAlertAction.Style.cancel, handler: nil)
                alert.addAction(cancelAction)
                present(alert, animated: true, completion: nil)
        }else if (transportSegControl.selectedSegmentIndex == 2){//bike
            transportImg.image=UIImage(named: "bike_icon")
            reportGasNeeded.text = "0 gallons"
        }
        updateCommute()
    }
    
    @IBAction func tankSlider(_ sender: UISlider) {
        let tankVal=sender.value //float
        gallonsInTank.text=String(format: "%.2f", tankVal)+"gallons"
    }
    
    @IBAction func commuteButton(_ sender: Any) {
        updateCommute()
    }
    
    @IBAction func monthlySwitch(_ sender: Any) {
        //20 work days, multiply totals by 20
        updateCommute()
    }
    
    
    func updateCommute(){
        //if car
        if transportSegControl.selectedSegmentIndex == 0 {
            //time= distance/speed (avg 20 mi/hr)
            if(commuteMiles.text!.isEmpty){ //no input, default to zero
                reportCommuteTime.text = "0 mins"
            }else{ //data is present
                var distance = Float(commuteMiles.text!)!
                if(monthlySwitch.isOn){ // switch on
                    distance = distance*20 //20 work days, multiply totals by 20
                    reportCommuteTime.text = String(format: "%.2f", distance/(20/60))+" mins"
                }else{//switch is off
                    if(distance==(20/60)){ // 20 mi/hr = .33mi/min
                        reportCommuteTime.text = "1 min"
                    }else{ //all others
                        reportCommuteTime.text = String(format: "%.2f", distance/(20/60))+" mins"
                    }//redundant, fix if time allows
                }
            }
            //gas = mi/gal (avg 24 mi/gallon)
            //gallons needed = distance/24
            if(commuteMiles.text!.isEmpty){ //no input, default to zero
                reportGasNeeded.text = "0 gallons"
            }else{ //data is present
                var distance = Float(commuteMiles.text!)!
                if(monthlySwitch.isOn){ // switch on
                    distance = distance*20
                }//do for both on and off switch
                if(distance==24){ // 24 miles takes 1 gallon
                    reportGasNeeded.text = "1 gallon"
                }else{ //all others
                    reportGasNeeded.text = String(format: "%.2f", distance/24)+" gallons"
                }
            }
        }//end car
        else if(transportSegControl.selectedSegmentIndex == 1){//if bus
                //time= distance/speed (avg 12 mi/hr) +5
            if(commuteMiles.text!.isEmpty){ //no input, default to zero
                    reportCommuteTime.text = "0 mins"
            }else{ //data is present
                var distance = Float(commuteMiles.text!)!
                if(monthlySwitch.isOn){ // switch on
                    distance = distance*20 //20 work days
                    reportCommuteTime.text = String(format: "%.2f", distance/(12/60) + 200 )+" mins" //plus 20*10 waiting mins
                }else{
                reportCommuteTime.text = String(format: "%.2f", distance/(12/60) + 10 )+" mins"
                }
            }
        }else if(transportSegControl.selectedSegmentIndex == 2){//if bike
            //time= distance/speed (avg 10 mi/hr)
            if(commuteMiles.text!.isEmpty){ //no input, default to zero
                reportCommuteTime.text = "0 mins"
            }else{ //data is present
                var distance = Float(commuteMiles.text!)!
                if(monthlySwitch.isOn){ // switch on
                    distance = distance*20 //20 work days
                }
                reportCommuteTime.text = String(format: "%.2f", distance/(10/60))+" mins"
            }
        }

        
        }
    
    func textFieldShouldReturn(_ textField: UITextField)-> Bool{
        textField.resignFirstResponder()
        return true
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        updateCommute()
    }
    
    override func viewDidLoad() {
        commuteMiles.delegate=self
        super.viewDidLoad()
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard))
        view.addGestureRecognizer(tap)
    }
    
    @objc func dismissKeyboard(){
        view.endEditing(true)
    }


}

