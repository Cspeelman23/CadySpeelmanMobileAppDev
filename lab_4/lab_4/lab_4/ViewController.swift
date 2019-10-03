//
//  ViewController.swift
//  lab_4
//
//  Created by Cady Speelman on 10/1/19.
//  Copyright © 2019 Cady Speelman. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var firstNum: UITextField!
    @IBOutlet weak var numStepper: UIStepper!
    @IBOutlet weak var stepperAmt: UILabel!
    @IBOutlet weak var resultsBox: UILabel!
    
    
    @IBAction func stepperMult(_ sender: Any) {
            stepperAmt.text = String(numStepper.value)
            updateResult()
    }
    
    func textFieldShouldReturn(_ textField: UITextField)-> Bool{
        textField.resignFirstResponder()
        return true
    }
    
    func updateResult(){
        var baseNum: Float
        var multiplier: Float
        if(firstNum.text!.isEmpty){
            baseNum = 0
        }else{
            baseNum = Float(firstNum.text!)!
        }
        if(baseNum <= 50){
            multiplier = Float(numStepper.value)
            let result = baseNum*multiplier
            resultsBox.text = String(result)
        }else{
            let alert = UIAlertController(title: "Warning", message: "Number may not exceed 50", preferredStyle: UIAlertController.Style.alert)
            let cancelAction = UIAlertAction(title: "Okay", style: UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction)
            present(alert, animated: true, completion: nil)
        }

    }
    
    func textFieldDidEndEditing(_ textfield: UITextField){
        updateResult()
    }

    override func viewDidLoad() {
        firstNum.delegate=self
        super.viewDidLoad()

        
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard))
        view.addGestureRecognizer(tap)
        // Do any additional setup after loading the view.
    }
    
    @objc func dismissKeyboard(){
        view.endEditing(true)
    }

    
}

