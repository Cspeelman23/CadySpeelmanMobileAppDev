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
    
    @IBOutlet weak var gallonsInTank: UILabel!
    
    
    
    
    @IBAction func tankSlider(_ sender: UISlider) {
        let tankVal=sender.value //float
        gallonsInTank.text=String(format: "%.2f", tankVal)+"gallons"
    }
    
    @IBAction func commuteButton(_ sender: Any) {
        updateCommute()
    }
    @IBAction func monthlySwitch(_ sender: Any) {
    }
    
    
    func updateCommute(){
        
        //time= distance/speed (avg 20 mi/hr)
        if(commuteMiles.text!.isEmpty){ //no input, default to zero
            reportCommuteTime.text = "0 mins"
        }else{
            let distance = Float(commuteMiles.text!)!
            if(distance==(20/60)){ // 20 mi/hr = .33mi/min
                    reportCommuteTime.text = "1 min"
                }else{ //all others
                    reportCommuteTime.text = String(format: "%.2f", distance/(20/60))+" mins"
                }
        }
        
        //gas = mi/gal (avg 24 mi/gallon)
        //gallons needed = distance/24
        if(commuteMiles.text!.isEmpty){ //no input, default to zero
            reportGasNeeded.text = "0 gallons"
        }else{
            let distance = Float(commuteMiles.text!)!
            if(distance==24){ // 24 miles takes 1 gallon
                reportGasNeeded.text = "1 gallon"
            }else{ //all others
                reportGasNeeded.text = String(format: "%.2f", distance/24)+" gallons"
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

