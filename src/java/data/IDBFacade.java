/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import control.ProjectDTO;

/**
 *
 * @author martamiszczyk
 */
interface IDBFacade
{
    public void SaveProject(ProjectDTO p) throws ClassNotFoundException;
}
