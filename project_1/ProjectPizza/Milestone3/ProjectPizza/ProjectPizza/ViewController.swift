//
//  ViewController.swift
//  ProjectPizza
//
//  Created by Cady Speelman on 9/30/19.
//  Copyright © 2019 Cady Speelman. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UIPickerViewDataSource, UIPickerViewDelegate {

    //--sauce
    @IBOutlet weak var sauceImg: UIImageView!
    @IBOutlet weak var sauceModImg: UIImageView!
    //--cheese
    @IBOutlet weak var cheeseImg: UIImageView!
    @IBOutlet weak var cheesePicker: UIPickerView!
    var cheeseTypes: [String] = [String]()
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return cheeseTypes.count
    }
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return cheeseTypes[row]
    }
    @IBOutlet weak var cheeseModImg: UIImageView!
    //--toppings
    @IBOutlet weak var pepperoniImg: UIImageView!
    @IBOutlet weak var mushroomImg: UIImageView!
    @IBOutlet weak var peppersImg: UIImageView!
    @IBOutlet weak var pepperoniSeg: UISegmentedControl!
    @IBOutlet weak var mushroomSeg: UISegmentedControl!
    @IBOutlet weak var pepperSeg: UISegmentedControl!
    @IBOutlet weak var toppingsModImg: UIImageView!
    //--slices
    @IBOutlet weak var sliceStepper: UIStepper!
    @IBOutlet weak var slicesNum: UILabel!
    @IBOutlet weak var slicesImg: UIImageView!
    @IBOutlet weak var slicesModImg: UIImageView!
    //--
    
    
    
    //RANDOM NUMBERS -------------------------
    //https://learnappmaking.com/random-numbers-swift/
    var sauceVal = Double.random(in: 0 ... 10)
    var cheeses = ["Cheddar", "Colbyjack", "Mozzarella", "Parmesan", "Provolone", "None"]
    lazy var cheeseVal = cheeses.randomElement() // lazy because "property initializers run before self is available"
    var pepperoniTopVal = Int.random(in: 0 ... 2)//0 = light, 1 = regular, 2 = extra
    var mushroomTopVal = Int.random(in: 0 ... 2)
    var pepperTopVal = Int.random(in: 0 ... 2)
    var slicesVal = Int.random(in: 0 ... 6)*2
    
    
    //ANSWER CHECKING AREA -------------------------
    //0 for not complete, 1 if correct
    var sauceModule = 0
    var cheeseModule = 0
    var toppingsModule = 0
    var Top1 = 0 //bool for pepperoni
    var Top2 = 0 //bool for mushroom
    var Top3 = 0 //bool for peppers
    var slicesModule = 0
    
    // checking for completion on each new input
    func checkAns() {
    //call this ftn to check on each new input
        if(sauceModule == 1 && cheeseModule == 1 && toppingsModule == 1) && slicesModule == 1{
            //alert win
            let alert = UIAlertController(title: "You Won!", message: "Play Again?", preferredStyle: UIAlertController.Style.alert)
            let nextAction = UIAlertAction(title: "New Level", style: UIAlertAction.Style.default, handler:{action in // basically reset storyboard except it wont let me
                self.sauceModule = 0
                self.cheeseModule = 0
                self.toppingsModule = 0
                self.Top1 = 0 //bool for pepperoni
                self.Top2 = 0 //bool for mushroom
                self.Top3 = 0 //bool for peppers
                self.slicesModule = 0
                self.sauceVal = Double.random(in: 0 ... 10)
                self.cheeses = ["Cheddar", "Colbyjack", "Mozzarella", "Parmesan", "Provolone", "None"]
                self.cheeseVal = self.cheeses.randomElement() // lazy because "property initializers run before self is available"
                self.pepperoniTopVal = Int.random(in: 0 ... 2)//0 = light, 1 = regular, 2 = extra
                self.mushroomTopVal = Int.random(in: 0 ... 2)
                self.pepperTopVal = Int.random(in: 0 ... 2)
                self.slicesVal = Int.random(in: 0 ... 6)*2
                self.sauceModImg.image=UIImage(named: "neutral")
                self.cheeseModImg.image=UIImage(named: "neutral")
                self.toppingsModImg.image=UIImage(named: "neutral")
                self.slicesModImg.image=UIImage(named: "neutral")
                self.sauceImg.alpha = 0;
                self.cheeseImg.image = UIImage(named: "None")
                self.cheeseTypes[0] = " "
                
                self.pepperoniImg.image = UIImage(named: "pepperoniNone")
                self.mushroomImg.image = UIImage(named: "mushroomNone")
                self.peppersImg.image = UIImage(named: "peppersNone")
                self.pepperoniSeg.selectedSegmentIndex = UISegmentedControl.noSegment
                self.mushroomSeg.selectedSegmentIndex = UISegmentedControl.noSegment
                self.pepperSeg.selectedSegmentIndex = UISegmentedControl.noSegment
                self.sliceStepper.value = 0
                self.slicesNum.text = "0"
                self.slicesImg.image = UIImage(named: "0slices")
                
                
            })
            alert.addAction(nextAction)
            present(alert, animated: true, completion: nil)
        }
    }
    
    
    
    //SAUCE MODULE -------------------------
    //https://www.youtube.com/watch?v=5I0oJ7kUFm0
    @IBAction func sauceSlider(_ sender: UISlider) { //0-10 in doubles
        let sauceAmt=sender.value //float
        sauceImg.alpha = CGFloat(Double(sauceAmt))/10
        if(sauceAmt <=  Float(Double(sauceVal+0.5)) && sauceAmt >=  Float(Double(sauceVal-0.5))){//within one of rng num (10%)
            sauceModImg.image=UIImage(named: "happy")
            sauceModule = 1
        }else{
            sauceModImg.image=UIImage(named: "neutral")
            sauceModule = 0
        }
        checkAns()
    }
    
    
    
    //CHEESE MODULE -------------------------
    //https://www.youtube.com/watch?v=BOgqcAcZCnI
    // adopt ui picker deligate and ui data source
    // chapter 12
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if(cheeseTypes[row] == cheeseVal){//string compare selected to random
            cheeseModImg.image=UIImage(named: "happy")
            cheeseModule = 1
        }else{
            cheeseModImg.image=UIImage(named: "neutral")
            cheeseModule = 0
        }
        cheeseImg.image = UIImage(named: cheeseTypes[row])//is string
    }

    
    
    
    //TOPPINGS MODULE -------------------------
    @IBAction func pepperoniAmtControl(_ sender: UISegmentedControl) {
        if(sender.selectedSegmentIndex == pepperoniTopVal){
            //if selected segment is correct
            Top1 = 1
        }
        else{
            // incorrect segment selected
            Top1 = 0
        }
        var appendString = "None"
        if(sender.selectedSegmentIndex == 0){
            appendString = "Light"
        }else if(sender.selectedSegmentIndex == 1){
            appendString = "Regular"
        }else if(sender.selectedSegmentIndex == 2){
            appendString = "Extra"
        }
        pepperoniImg.image=UIImage(named: "pepperoni" + appendString)
        toppingsCheck()
    }
    @IBAction func mushroomAmtControl(_ sender: UISegmentedControl) {
        if(sender.selectedSegmentIndex == mushroomTopVal){
            //if selected segment is correct
            Top2 = 1
        }
        else{
            // incorrect segment selected
            Top2 = 0
        }
        var appendString = "None"
        if(sender.selectedSegmentIndex == 0){
            appendString = "Light"
        }else if(sender.selectedSegmentIndex == 1){
            appendString = "Regular"
        }else if(sender.selectedSegmentIndex == 2){
            appendString = "Extra"
        }
        mushroomImg.image=UIImage(named: "mushroom" + appendString)
        toppingsCheck()
    }
    @IBAction func pepperAmtControl(_ sender: UISegmentedControl) {
        if(sender.selectedSegmentIndex == pepperTopVal){
            //if selected segment is correct
            Top3 = 1
        }
        else{
            // incorrect segment selected
            Top3 = 0
        }
        var appendString = "None"
        if(sender.selectedSegmentIndex == 0){
            appendString = "Light"
        }else if(sender.selectedSegmentIndex == 1){
            appendString = "Regular"
        }else if(sender.selectedSegmentIndex == 2){
            appendString = "Extra"
        }
        peppersImg.image=UIImage(named: "peppers" + appendString)
        toppingsCheck()
    }
    func toppingsCheck(){
        print("Pepperoni: " , pepperoniTopVal , "   Mushroom: " , mushroomTopVal , "    Pepper: " , pepperTopVal)
        print("Toppings bools: " , Top1 , " , " , Top2 , " , " , Top3)
        if(Top1 == 1 && Top2 == 1 && Top3 == 1){ //if pepperoni,mushroom,and pepper are all correct
            toppingsModule = 1
            toppingsModImg.image=UIImage(named: "happy")
            checkAns()
        }else{
            toppingsModImg.image=UIImage(named: "neutral")
        }
        
    }
    
    
    
    
    //SLICES MODULE -------------------------
    @IBAction func slicePizzaCutter(_ sender: UIStepper) {
        let numSlices = String(Int(sender.value)) + "slices"
        slicesImg.image=UIImage(named: numSlices)
        slicesNum.text = String(Int(sender.value))
        if(Int(sender.value) == slicesVal){//matches set num of slices, ------not checking on page load
            slicesModImg.image=UIImage(named: "happy")
            slicesModule = 1 //------local only?
        }else{
            slicesModImg.image=UIImage(named: "neutral")
            slicesModule = 0
        }
        checkAns()
    }
    
    
    
    
    
    // -------------------------
    override func viewDidLoad() {
        
        super.viewDidLoad()
        cheesePicker.delegate = self
        cheesePicker.dataSource = self
        cheeseTypes = [" ", "Cheddar", "Colbyjack", "Mozzarella", "Parmesan", "Provolone", "None"]
        
        print(cheeseVal!)
        // Do any additional setup after loading the view.
    }
    
    
}

