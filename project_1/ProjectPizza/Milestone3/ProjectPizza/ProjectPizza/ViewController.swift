//
//  ViewController.swift
//  ProjectPizza
//
//  Created by Cady Speelman on 9/30/19.
//  Copyright © 2019 Cady Speelman. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    // adopt ui picker deligate and ui data source
    // chapter 12
    
    //--sauce
    @IBOutlet weak var sauceImg: UIImageView!
    @IBOutlet weak var sauceModImg: UIImageView!
    
    //--cheese
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
    
    //RANDOM NUMBERS
    //https://learnappmaking.com/random-numbers-swift/
    let sauceVal = Double.random(in: 0 ... 10)
    
    let pepperoniTopVal = Int.random(in: 0 ... 2)//0 = light, 1 = regular, 2 = extra
    let mushroomTopVal = Int.random(in: 0 ... 2)
    let pepperTopVal = Int.random(in: 0 ... 2)
    let slicesVal = Int.random(in: 0 ... 6)*2
    
    
    
    
    //ANSWER CHECKING AREA
    //0 for not complete, 1 if correct
    var sauceModule = 0
    
    var toppingsModule = 0
    var Top1 = 0
    var Top2 = 0
    var Top3 = 0
    var slicesModule = 0
    
    // checking for completion on each new input
    func checkAns() {
 
    
    //cheese selected in selectedRow in component 0
    //call check on...input?
    //    if(sauceModule == 1 && cheeseModule == 1 && toppingsModule == 1) && slicesModule == 1{
    //        //alert win
    //    }
    }
    
    //SAUCE MODULE
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
    
    
    //CHEESE MODULE
    
    
    
    //TOPPINGS MODULE
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
    
    
    //SLICES MODULE
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
    
    
    
    
    
    
    override func viewDidLoad() {
        print(slicesVal)
        checkAns()
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    
}

