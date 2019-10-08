//
//  ViewController.swift
//  ProjectPizza
//
//  Created by Cady Speelman on 9/30/19.
//  Copyright © 2019 Cady Speelman. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var sauceImg: UIImageView!
    @IBOutlet weak var sauceModImg: UIImageView!
    
    
    //RANDOM NUMBERS
    //https://learnappmaking.com/random-numbers-swift/
    let sauceVal = Double.random(in: 0 ..< 10)
    
    //ANSWER CHECKING AREA
    //0 for not complete, 1 if correct
    var sauceModule = 0
    var cheeseModule = 0
    
    //call check on...input?
    //    if(sauceModule == 1 && cheeseModule == 1){
    //        //alert win
    //    }
    
    
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
    }
    
    
    //CHEESE MODULE
    
    
    
    
    
    
    
    
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    
}

