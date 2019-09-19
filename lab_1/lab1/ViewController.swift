//
//  ViewController.swift
//  lab1
//
//  Created by Cadence Speelman on 9/3/19.
//  Copyright © 2019 Cadence Speelman. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBAction func selectButton(_ sender: UIButton) {
        if sender.tag == 1{
            beeImage.image = UIImage(named: "comb")
            textLabel.text = "Bees on a honeycomb"
        }else if sender.tag == 2{
            beeImage.image = UIImage(named: "drawing")
            textLabel.text = "Watercolor bee :)"
        }
    }
    
    @IBOutlet weak var beeImage: UIImageView!
    @IBOutlet weak var textLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

