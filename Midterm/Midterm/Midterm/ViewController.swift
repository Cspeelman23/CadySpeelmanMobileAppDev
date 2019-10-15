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
    
    
    
    func updateCommute(){
        
        //time= distance/speed
        
        if(commuteMiles.text!.isEmpty){ //no input, default to zero
            reportCommuteTime.text = "0 mins"
        }else{
            let distance = Float(commuteMiles.text!)!
            if(distance==(20/60)){ // 20 mi/hr = .33mi/min
                    reportCommuteTime.text = "1 min"
                }else{ //all others
                    reportCommuteTime.text = String(distance/(20/60))+" mins"
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

