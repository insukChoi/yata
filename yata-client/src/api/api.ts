import initializeAxios from './axiosSetup'
import {axiosRequestConfiguration} from './config'
import {map} from 'rxjs/operators'
import {defer, Observable} from 'rxjs'

const axiosInstance = initializeAxios(axiosRequestConfiguration)

const getInstance = () => {
  return axiosInstance;
}

const getForThen = <T>(url: string, queryParams?: object) => {
  return axiosInstance.get<T>(url, {params: queryParams})
};

const get = <T>(url: string, queryParams?: object): Observable<T> => {
  return defer(() => axiosInstance.get<T>(url, {params: queryParams}))
  .pipe(map(result => result.data))
};

const post = <T>(url: string, body: object, queryParams?: object): Observable<T> => {
  return defer(() => axiosInstance.post<T>(url, body, {params: queryParams}))
  .pipe(map(result => result.data));
};

const put = <T>(url: string, body: object, queryParams?: object): Observable<T> => {
  return defer(() => axiosInstance.put<T>(url, body, {params: queryParams}))
  .pipe(map(result => result.data));
};

const patch = <T>(url: string, body: object, queryParams?: object): Observable<T> => {
  return defer(() => axiosInstance.patch<T>(url, body, {params: queryParams}))
  .pipe(map(result => result.data));
};

const deleteR = <T>(url: string, id: number): Observable<T> => {
  return defer(() => (axiosInstance.delete(`${url}/${id}`)))
  .pipe(map(result => result.data)
  );
};

export default {getInstance, getForThen, get, post, put, patch, delete: deleteR};
