//
//  ViewController.swift
//  lab_3
//
//  Created by Cady Speelman on 9/19/19.
//  Copyright © 2019 Cady Speelman. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var foodImage: UIImageView!
    @IBOutlet weak var segControl: UISegmentedControl!
    @IBOutlet weak var shoutySwitch: UISwitch!
    @IBOutlet weak var titleLabel: UILabel!
    
    func updateImage(){
        if segControl.selectedSegmentIndex == 0 {
            titleLabel.text="Funnel Cake"
            foodImage.image=UIImage(named: "funnelCake")
        }
        else if segControl.selectedSegmentIndex == 1 {
            titleLabel.text="Corn Dogs"
            foodImage.image=UIImage(named: "cornDogs")
        }
    }
    func updateTitleText(){
        if shoutySwitch.isOn{
            titleLabel.text=titleLabel.text?.uppercased()
            titleLabel.textColor=UIColor.red
        }else{
            titleLabel.text=titleLabel.text?.lowercased()
            titleLabel.textColor=UIColor.black
        }
    }
    
    @IBAction func controlUpdate(_ sender: UISegmentedControl) {
        updateImage()
        updateTitleText()
    }
    
    @IBAction func sliderToggle(_ sender: UISwitch) {
        updateTitleText()
    }
    
    @IBAction func sliderUpdate(_ sender: UISlider) {
        let fontSize=sender.value //float
        let fontSizeCGFloat=CGFloat(fontSize) //float to CGFloat
        titleLabel.font=UIFont.systemFont(ofSize: fontSizeCGFloat)//uifont obj assigned to font property
    }
    
    
    func setThumbImage(_ image: UIImage?, for state: UIControl.State){
        
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

