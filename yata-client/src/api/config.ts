import {AxiosRequestConfig} from 'axios'

export const axiosRequestConfiguration: AxiosRequestConfig = {
  baseURL: '/api',
  responseType: 'json',
  headers: {
    'Content-Type': 'application/json',
  },
}