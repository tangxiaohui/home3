#!/usr/bin/env python 
# -*- coding: utf-8 -*-

import os
import shine

if __name__ == '__main__':
	os.chdir(os.getcwd() + '/jar')
	shine.runJava('tools.jar dataExport true 2')
	os.system("pause")
